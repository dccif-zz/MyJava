package top.dccif.Merge;

import org.springframework.stereotype.Service;
import top.dccif.cmdparams.Cmdparam;

@Service
public interface ConvertVideo {
    void convert(Cmdparam cmdparam, String outName);
}
