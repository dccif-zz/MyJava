package top.dccif.Merge;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import top.dccif.cmdparams.Cmdparam;

@Service
public class ConvertTomp4 implements ConvertVideo {
    private Cmdparam cmdparam;
    private String outName;

    public ConvertTomp4() {
    }

    public ConvertTomp4(Cmdparam cmdparam, String outName) {
        this.cmdparam = cmdparam;
        this.outName = outName;
    }

    @Async
    @Override
    public void convert(Cmdparam cmdparam, String outName) {

    }

    public Cmdparam getCmdparam() {
        return cmdparam;
    }

    public void setCmdparam(Cmdparam cmdparam) {
        this.cmdparam = cmdparam;
    }

    public String getOutName() {
        return outName;
    }

    public void setOutName(String outName) {
        this.outName = outName;
    }
}
