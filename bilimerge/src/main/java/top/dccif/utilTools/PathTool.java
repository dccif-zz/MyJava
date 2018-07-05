package top.dccif.utilTools;

import org.json.JSONObject;
import top.dccif.cmdparams.Cmdparam;
import top.dccif.convert.Convert;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <h1>主工具类</h1>
 * 这是一个<strong>核心工具类</strong>，构造需要注入一个<strong>命令行参数类</strong>
 * <p>用户的主要使用类，目的是为开始转换生成文件和启动转换</p>
 * <p>根据 JDK1.8 编译,因为使用了Java8的新语法，不保证向下兼容性</p>
 * <p>内部方法可以实现读取</p>
 *
 * @author dccif
 * @version 1.4
 */
public class PathTool {
    /**
     * 方法常量定义
     * <p>定义了bilibili客户端的下载格式与info文件</p>
     * <p>生成临时的ffmpeg转换所需要的input.txt文件</p>
     */
    private static final String FILE_EXT = "flv";
    private static final String FILE_TEMP = "\\input.txt";
    private static final String FILE_INFO = ".info";
    // 文件列表
    private List<File> fileList = new LinkedList<>();
    // 命令行参数
    private Cmdparam cmdparam;

    private List<Convert> convertTaskList = new LinkedList<>();

    /**
     * 构造方法
     *
     * @param cmdparam 必须注入一个命令行参数的
     * @see Cmdparam
     */
    public PathTool(Cmdparam cmdparam) {
        this.cmdparam = cmdparam;
    }

    /**
     * 核心方法
     * 读取构造时注入的路径参数，生成ffmpeg所需文件
     * 会产生副作用，生成文件,和任务队列
     *
     * @return this 为了链式调用
     */
    public PathTool getPathAndGen() {
        String currFile = "";
        List<File> currFiles = new ArrayList<>();
        // 获取输入路径，如果不存在着创建
        File outDir = new File(cmdparam.getOutFilePath());
        if (!outDir.exists())
            outDir.mkdir();
        System.out.println("Out Dir is :" + outDir.getAbsolutePath());

        // 开始遍历给定文件目录,采用非递归遍历
        File root = new File(cmdparam.getInFilePath());
        if (root.exists()) {
            LinkedList<File> list;
            File[] files = root.listFiles();

            list = Arrays.stream(files != null ? files : new File[0])
                    .filter(File::isDirectory)
                    .collect(Collectors.toCollection(LinkedList::new));

            File currDir;
            while (!list.isEmpty()) {
                currDir = list.removeFirst();
                files = currDir.listFiles();
                Arrays.stream(files != null ? files : new File[0])
                        .forEach(file2 -> {
                            if (file2.isDirectory()) {
                                list.add(file2);
                            }
                            if (file2.getName().endsWith(FILE_EXT)) {
                                fileList.add(file2);
                                currFiles.add(file2);
                            }
                        });
                currFiles.sort((o1, o2) -> {
                    String[] fileindex1 = o1.getName().split("_");
                    Integer in1 = Integer.parseInt(fileindex1[2].substring(0, fileindex1[2].lastIndexOf(FILE_EXT) - 1));
                    String[] fileindex2 = o2.getName().split("_");
                    Integer in2 = Integer.parseInt(fileindex2[2].substring(0, fileindex2[2].lastIndexOf(FILE_EXT) - 1));
                    return Integer.compare(in1, in2);
                });
                currFile = filetxtGen(currFiles);

                // 转换线程 or 异步方法
                // 添加转换任务
                convertTaskList.add(new Convert(currDir.getAbsolutePath(),
                        outDir.getAbsolutePath(),
                        currFile));

                currFiles.clear();
            }
        } else {
            System.out.println("No such dir");
        }

        fileList = fileList.parallelStream()
                .map(File::getParentFile)
                .distinct()
                .collect(Collectors.toList());

        return this;
    }

    /**
     * 获取任务队列
     *
     * @return 任务列表
     */
    public List<Convert> getConvertTaskList() {
        return convertTaskList;
    }


    /**
     * 测试用方法，根据文件列表执行清理临时文件操作
     *
     * @param fileList 生成的文件列表
     * @deprecated
     */
    public void fileDelete(List<File> fileList) {
        fileList.forEach(file -> {
            try {
                File deleteFile = new File(file.getPath() + "\\input.txt");
                if (deleteFile.exists())
                    deleteFile.delete();
            } catch (NoSuchFieldError e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 工作方法
     * 启动线程池，以使用并行
     *
     * @return this 为了链式调用
     */
    public PathTool startMerge() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(convertTaskList.size());
        for (Convert convert : convertTaskList) {
            fixedThreadPool.submit(convert);
        }
        fixedThreadPool.shutdown();
        return this;
    }

    /***
     * 根据路径生成ffmpeg要求的input.txt文件
     * 同时读取当前路径下的info文件，生成文件名
     * @return outfile 当前文件的简略名
     */
    private String filetxtGen(List<File> filelist) {
        File firstFile = filelist.get(0);
        String[] outFilename = firstFile.getName().split("_");
        String filename = "";

        try (FileWriter fw = new FileWriter(firstFile.getParent() + FILE_TEMP);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            for (File file : filelist) {
                String filepathEsc = file.getAbsolutePath().replaceAll("\\\\", "\\\\\\\\");
                if (File.separatorChar == '\\') {
                    out.println("file " + filepathEsc);
                } else {
                    out.println("file " + filepathEsc);
                }
            }
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder lines = new StringBuilder();
        try (Stream<String> stringStream = Files.lines(Paths.get(firstFile.getParent() + "\\" + outFilename[0] + FILE_INFO))) {
            stringStream.forEach(lines::append);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject obj = new JSONObject(lines.toString());
        Pattern begDig = Pattern.compile("^\\d{1,3}");
        filename = obj.getString("PartName");
        if (!begDig.matcher(filename).lookingAt()) {
            filename = obj.getString("PartNo") + "_" + obj.getString("PartName") + ".mp4";
        }

        return filename;
    }
}
