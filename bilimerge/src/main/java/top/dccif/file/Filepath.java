package top.dccif.file;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "prototype")
public class Filepath {
    private static String inFilePath;
    private static String outFilePath;

    public Filepath() {
    }

    public Filepath(String inFilePath, String outFilePath) {
        Filepath.inFilePath = inFilePath;
        Filepath.outFilePath = outFilePath;
    }

    public String getInFilePath() {
        return inFilePath;
    }

    public void setInFilePath(String inFilePath) {
        Filepath.inFilePath = inFilePath;
    }

    public String getOutFilePath() {
        return outFilePath;
    }

    public void setOutFilePath(String outFilePath) {
        Filepath.outFilePath = outFilePath;
    }
}
