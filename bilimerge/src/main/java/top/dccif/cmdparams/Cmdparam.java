package top.dccif.cmdparams;

import java.io.File;

/**
 * <h1>命令行参数类</h1>
 * 由用户输入的参数构成，目前只接受两个参数
 * <p>可以自由输入路径，会自动去除最后一个路径分隔符</p>
 *
 * @author dccif
 * @version 1.4
 */
//@Component
//@Scope(scopeName = "prototype")
public class Cmdparam {
    private static String inFilePath;
    private static String outFilePath;
    private static String sepator = File.separator;

    public Cmdparam() {
    }

    public Cmdparam(String inFilePath, String outFilePath) {
        if (inFilePath.endsWith(sepator))
            inFilePath = inFilePath.substring(0, inFilePath.length() - 1);
        Cmdparam.inFilePath = inFilePath;

        if (outFilePath.endsWith(sepator))
            outFilePath = outFilePath.substring(0, outFilePath.length() - 1);
        Cmdparam.outFilePath = outFilePath;
    }

    public static String getSepator() {
        return sepator;
    }

    public String getInFilePath() {
        return inFilePath;
    }

    public void setInFilePath(String inFilePath) {
        Cmdparam.inFilePath = inFilePath;
    }

    public String getOutFilePath() {
        return outFilePath;
    }

    public void setOutFilePath(String outFilePath) {
        Cmdparam.outFilePath = outFilePath;
    }
}
