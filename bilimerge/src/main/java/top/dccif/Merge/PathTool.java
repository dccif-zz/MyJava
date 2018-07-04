package top.dccif.Merge;


import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/***
 * 根据路径获取路径下所有文件
 */
public class PathTool {
    /***
     * b站默认下载的flv文件
     * input.txt 为ffmpeg要求的合并文件
     */
    private static final String FILE_EXT = "flv";
    private static final String FILE_TEMP = "\\input.txt";
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            4, Integer.MAX_VALUE, 300L, TimeUnit.SECONDS,
            new SynchronousQueue<>());
    private List<File> filelist = new LinkedList<>();

    /***
     * 根据 文件后缀获取目录下所有flv文件并生成ffmpeg合并所需的input.txt文件
     * @param filePath 目标路径，根据命令行读入
     * @param outPath 输入路径，根据命令行读入
     * @return 符合条件的所有文件的ArrayList列表
     */
    public List<File> getPathAndGen(String filePath, String outPath) {

        String currFile = "";
        List<File> currFiles = new ArrayList<>();
        // 获取输入路径，如果不存在着创建
        File outDir = new File(outPath);
        if (!outDir.exists())
            outDir.mkdir();
        System.out.println("Out Dir is :" + outPath);

        // 开始遍历给定文件目录,采用非递归遍历
        File root = new File(filePath);
        if (root.exists()) {
            LinkedList<File> list = new LinkedList<>();
            File[] files = root.listFiles();

            for (File file2 : files != null ? files : new File[0]) {
                if (file2.isDirectory()) {
                    list.add(file2);
                }
            }

            File currDir;
            while (!list.isEmpty()) {
                currDir = list.removeFirst();
                files = currDir.listFiles();
                for (File file2 : files != null ? files : new File[0]) {
                    if (file2.isDirectory()) {
                        list.add(file2);
                    }
                    if (file2.getName().endsWith(FILE_EXT)) {
                        filelist.add(file2);
                        currFiles.add(file2);
//                        currFile = filetxtGen(file2);
                    }
                }
                currFiles.sort(new fileIndexComp());
                currFile = filetxtGen(currFiles);
                currFiles.clear();
                // input.txt文件生成完毕
                // 开始合并
//                mergeTasks.add(new mergeTask(currDir.getAbsolutePath(),currFile,outPath));
//                threadPool.submit(new mergeTask(currDir.getAbsolutePath(),currFile,outPath));
//                threadPool
                new mergeThread(currDir.getAbsolutePath(), currFile, outPath).run();
//                threadPoolExecutor.submit(new mergeThread(currDir.getAbsolutePath(),currFile,outPath));
//                Executors.callable(new mergeTask(currDir.getAbsolutePath(), currFile, outPath));

            }
        } else {
            System.out.println("No such cmdparams");
        }

        return filelist;
    }

    /***
     * 根据路径生成ffmpeg要求的input.txt文件
     * @return outfile 当前文件的简略名
     */
    private String filetxtGen(List<File> filelist) {
        File firstFile = filelist.get(0);
        String[] outFilename = firstFile.getName().split("_");

        try (FileWriter fw = new FileWriter(firstFile.getParent() + FILE_TEMP, true);
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

    /***
     * 根据路径生成ffmpeg要求的input.txt文件
     * @param file 文件句柄
     * @return outfile 当前文件的简略名
     */
    private String filetxtGen(File file) {
        // 采用缓冲，避免重复打开文件
        try (FileWriter fw = new FileWriter(file.getParent() + FILE_TEMP, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)
        ) {
            // 文件路径的转义,使用正则表达式
            String filepathEsc = file.getAbsolutePath().replaceAll("\\\\", "\\\\\\\\");
            if (File.separatorChar == '\\') {
                out.println("file " + filepathEsc);
            } else {
                out.println("file " + filepathEsc);
            }
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] out = file.getName().split("_");

        return out[0] + "_" + out[1] + ".mp4";
    }

    /***
     * 清理生成的input.txt文件
     * @param fileList 生成input.txt的flv文件列表
     */
    public void fileDelete(List<File> fileList) {
        for (File file : fileList) {
            try {
                File deleteFile = new File(file.getParentFile() + "\\" + FILE_TEMP);
                if (deleteFile.exists())
                    deleteFile.delete();
            } catch (NoSuchFieldError e) {
                e.printStackTrace();
            }
        }
    }

    private void fileDelete(File file) {
        try {
            File file2 = new File(file.getParent() + FILE_TEMP);
            if (file2.exists())
                file2.delete();
        } catch (NoSuchFieldError e) {
            e.printStackTrace();
        }
    }

    private void fileDelete(String file) {
        try {
            File in = new File(file);
            if (in.exists())
                in.delete();
        } catch (NoSuchFieldError e) {
            e.printStackTrace();
        }
    }

    private class fileIndexComp implements Comparator<File> {

        @Override
        public int compare(File o1, File o2) {
            String[] fileindex1 = o1.getName().split("_");
            Integer in1 = Integer.parseInt(fileindex1[2].substring(0, fileindex1[2].lastIndexOf(FILE_EXT) - 1));
            String[] fileindex2 = o2.getName().split("_");
            Integer in2 = Integer.parseInt(fileindex2[2].substring(0, fileindex2[2].lastIndexOf(FILE_EXT) - 1));
            return Integer.compare(in1, in2);
        }
    }

}
