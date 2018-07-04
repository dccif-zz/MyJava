package top.dccif.utilTools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dccif.cmdparams.Cmdparam;
import top.dccif.convert.Convert;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class PathTool {
    private static final String FILE_EXT = "flv";
    private static final String FILE_TEMP = "\\input.txt";
    CompletableFuture<Void> convertTask;
    private Cmdparam cmdparam;
    private List<File> fileList = new LinkedList<>();

    private List<Convert> convertTaskList = new LinkedList<>();

    @Autowired
    public PathTool(Cmdparam cmdparam) {
        this.cmdparam = cmdparam;
    }

    public List<File> getPathAndGen() {
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
                convertTaskList.add(new Convert(currDir.getAbsolutePath(),
                        outDir.getAbsolutePath(),
                        currFile));

                currFiles.clear();
            }
        } else {
            System.out.println("No such cmdparams");
        }

        fileList = fileList.parallelStream()
                .map(File::getParentFile)
                .distinct()
                .collect(Collectors.toList());

        return fileList;
    }

    /***
     * 根据路径生成ffmpeg要求的input.txt文件
     * @return outfile 当前文件的简略名
     */
    private String filetxtGen(List<File> filelist) {
        File firstFile = filelist.get(0);
        String[] outFilename = firstFile.getName().split("_");

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
                fw.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return outFilename[0] + "_" + outFilename[1] + ".mp4";
    }

    public List<Convert> getConvertTaskList() {
        return convertTaskList;
    }

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
}
