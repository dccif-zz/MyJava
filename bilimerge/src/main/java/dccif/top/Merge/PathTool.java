package dccif.top.Merge;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    private ArrayList<String> filelist = new ArrayList<>();

    //TODO 线程池优化
    private ExecutorService fixThreadPool = Executors.newFixedThreadPool(10);

    /***
     * 根据 文件后缀获取目录下所有flv文件并生成ffmpeg合并所需的input.txt文件
     *      再根据input.txt文件进行合并操作
     * @param filePath 目标路径，根据命令行读入
     * @param outPath  输出文件夹 根据命令行读入
     * @return 符合条件的所有文件的ArrayList列表
     */
    public ArrayList<String> getPath(String filePath, String outPath) throws InterruptedException {

        File outDir = new File(outPath);
        if (!outDir.exists())
            outDir.mkdir();
        System.out.println("输出文件夹为:");

        File root = new File(filePath);
        if (root.exists()) {
            LinkedList<File> list = new LinkedList<>();
            File[] files = root.listFiles();

            for (File file2 : files) {
                if (file2.isDirectory()) {
                    list.add(file2);
                }
            }

            File temp_file;
            while (!list.isEmpty()) {
                temp_file = list.removeFirst();
                files = temp_file.listFiles();
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        list.add(file2);
                    }
                    if (file2.getName().endsWith(FILE_EXT)) {

                        filelist.add(file2.getName());
                        filetxtGen(file2);

//                        flvtomp4(file2, outPath);
                        Thread my = new mergeThread(file2, outPath);
                        my.start();
                        my.join();
//
//                        filedelete(file2);
                    }
                }
            }
        } else {
            System.out.println("No such file");
        }

        return filelist;
    }

    /***
     * 根据路径生成ffmpeg要求的input.txt文件
     * @param file 文件句柄
     */
    private void filetxtGen(File file) {
        try (FileWriter fw = new FileWriter(file.getParent() + FILE_TEMP, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)
        ) {
            String filepathEsc = file.getAbsolutePath().replaceAll("\\\\", "\\\\\\\\");
            if (file.separatorChar == '\\') {
                out.println("file " + filepathEsc);
            } else {
                out.println("file " + filepathEsc);
            }
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
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

    private class mergeThread extends Thread {
        private File file;
        private String outpath;

        public mergeThread(File context, String filepath) {
            file = context;
            this.outpath = filepath;
        }

        private void flvtomp4() {
            File file2 = new File(file.getParentFile() + "\\input.txt");
            if (file2.exists()) {

                String input = file.getParentFile() + "\\input.txt";

                String[] outname = file.getName().split("_");
                String outfile = outname[0] + "_" + outname[1] + ".mp4";
                outfile = outpath + "\\" + outfile;


//                String output = file.getParentFile() + "\\temp.mp4";

//        String outname = file.getAbsolutePath();
//        String[] out = outname.split("\\\\");
//        System.out.println(out);
                String[] incmd = {"ffmpeg.exe",
                        "-loglevel", "quiet",
                        "-f", "concat",
                        "-safe", "0",
                        "-i", input,
                        "-c", "copy", outfile};

                try {
                    Process process = Runtime.getRuntime().exec(incmd);
//                    process.wait(100);
//                    process.waitFor();
                } catch (IOException e) {
                    e.printStackTrace();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
                }
            } else {
                return;
            }
        }

        @Override
        public void run() {
            super.run();
            flvtomp4();
        }
    }
}
