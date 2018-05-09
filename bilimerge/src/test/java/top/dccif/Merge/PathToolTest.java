package top.dccif.Merge;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class PathToolTest {

    private List<File> filelist = new LinkedList<>();

//    File file = new File("E:\\BiliDown\\9876107");
//    filelist = getPathAndGen("E:\\BiliDown\\9876107", "E:\\BiliDown\\out");

    public List<File> init() {
        File file = new File("E:\\BiliDown\\9876107");
        filelist = getPathAndGen("E:\\BiliDown\\9876107", "E:\\BiliDown\\out");
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
                    }
                }

            }
        } else {
            System.out.println("No such file");
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


    @Test
    public void cleanFile(){
        init();
        fileDelete(filelist);
    }

}