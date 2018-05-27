package top.dccif.Merge;

import org.springframework.stereotype.Service;
import top.dccif.file.Filepath;

@Service
public interface ConvertVideo {
    void convert(Filepath filepath, String outName);
}
