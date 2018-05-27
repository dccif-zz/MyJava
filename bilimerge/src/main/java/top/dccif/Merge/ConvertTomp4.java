package top.dccif.Merge;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import top.dccif.file.Filepath;

@Service
public class ConvertTomp4 implements ConvertVideo {
    private Filepath filepath;
    private String outName;

    public ConvertTomp4() {
    }

    public ConvertTomp4(Filepath filepath, String outName) {
        this.filepath = filepath;
        this.outName = outName;
    }

    @Async
    @Override
    public void convert(Filepath filepath, String outName) {

    }

    public Filepath getFilepath() {
        return filepath;
    }

    public void setFilepath(Filepath filepath) {
        this.filepath = filepath;
    }

    public String getOutName() {
        return outName;
    }

    public void setOutName(String outName) {
        this.outName = outName;
    }
}
