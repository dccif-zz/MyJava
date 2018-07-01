package top.dccif.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dccif.file.Filepath;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PathTool {
    private static final String FILE_EXT = "flv";
    private static final String FILE_TEMP = "\\input.txt";
    private Filepath filepath;
    private List<File> fileList = new LinkedList<>();

    @Autowired
    public PathTool(Filepath filepath) {
        this.filepath = filepath;
    }

    List<File> getPathAndGen() {
        String currFile = "";
        List<File> currFiles = new ArrayList<>();
        // 获取输入路径，如果不存在着创建
        File outDir = new File(filepath.getOutFilePath());
        if (!outDir.exists())
            outDir.mkdir();
        System.out.println("Out Dir is :" + outDir.getAbsolutePath());

        // 开始遍历给定文件目录,采用非递归遍历
        File root = new File(filepath.getInFilePath());
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
                currFiles.clear();
            }
        } else {
            System.out.println("No such file");
        }

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

    void fileDelete(List<File> fileList) {
        fileList.forEach(file -> {
            try {
                File deleteFile = new File(file.getParentFile() + "\\input.txt");
                if (deleteFile.exists())
                    deleteFile.delete();
            } catch (NoSuchFieldError e) {
                e.printStackTrace();
            }
        });
    }
}
