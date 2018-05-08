package top.dccif.Merge;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

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
    private List<File> filelist = new LinkedList<>();

    /***
     * 根据 文件后缀获取目录下所有flv文件并生成ffmpeg合并所需的input.txt文件
     * @param filePath 目标路径，根据命令行读入
     * @return 符合条件的所有文件的ArrayList列表
     */
    public List<File> getPathAndGen(String filePath, String outPath) {

        String currFile = "";
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

            for (File file2 : files) {
                if (file2.isDirectory()) {
                    list.add(file2);
                }
            }

            File currDir;
            while (!list.isEmpty()) {
                currDir = list.removeFirst();
                files = currDir.listFiles();
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        list.add(file2);
                    }
                    if (file2.getName().endsWith(FILE_EXT)) {
                        filelist.add(file2);
                        currFile = filetxtGen(file2);
                    }
                }
                // input.txt文件生成完毕
                // 开始合并
                new mergeThread(currDir.getAbsolutePath(), currFile, outPath).run();

            }
        } else {
            System.out.println("No such file");
        }

        return filelist;
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

}
