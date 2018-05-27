package top.dccif.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dccif.Merge.ConvertVideo;
import top.dccif.file.Filepath;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

@Service
public class PathTool {
    private Filepath filepath;
    private List<File> fileList = new LinkedList<>();

    @Autowired
    public PathTool(Filepath filepath) {
        this.filepath = filepath;
    }

    public List<File> getPathAndGen(Filepath filepath, ConvertVideo converter) {

        System.out.println(filepath.getInFilePath());
        return fileList;
    }
}
