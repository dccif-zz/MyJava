package top.dccif.Merge;

import org.junit.Test;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class PathToolTest {

    private List<File> filelist = new LinkedList<>();

//    File cmdparams = new File("E:\\BiliDown\\9876107");
//    filelist = getPathAndGen("E:\\BiliDown\\9876107", "E:\\BiliDown\\out");

    public List<File> init() {
        File file = new File("E:\\BiliDown\\22683925");
        filelist = getPathAndGen("E:\\BiliDown\\22683925", "E:\\BiliDown\\out");
        return filelist;
    }

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
                    if (file2.getName().endsWith("flv")) {
                        filelist.add(file2);
                        //currFile = filetxtGen(file2);
                    }
                }

            }
        } else {
            System.out.println("No such cmdparams");
        }

        return filelist;
    }

    public int fileDelete(List<File> fileList) {
        for (File file : fileList) {
            try {
                File deleteFile = new File(file.getParentFile() + "\\input.txt");
                if (deleteFile.exists())
                    deleteFile.delete();
            } catch (NoSuchFieldError e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    private String filetxtGen(File file) {
        // 采用缓冲，避免重复打开文件
        try (FileWriter fw = new FileWriter(file.getParent() + "\\input.txt", true);
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

    @Test
    public void genFile() {
        init();
    }


    @Test
    public void cleanFile(){
        init();
        fileDelete(filelist);
    }

}