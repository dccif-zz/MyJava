package top.dccif.convert;

import java.io.File;

/**
 * <h1>转换类</h1>
 * 读入路径下的input文件启动同路径下的ffmpeg 以完成转换
 * 转换完成后会自动删除生成的input文件
 *
 * @author dccif
 */
public class Convert implements Runnable {
    private String intxtpath;
    private String outfilename;
    private String outfile;

    public Convert(String infilepath, String outfilepath, String outfilename) {
        this.intxtpath = infilepath + "\\input.txt";
        this.outfilename = outfilename;
        this.outfile = outfilepath + "\\" + outfilename;
    }

    private void converTomp4() {
        File intxt = new File(intxtpath);
        if (intxt.exists()) {
            String[] incmd = {"ffmpeg.exe",
                    "-loglevel", "quiet",
                    "-f", "concat",
                    "-safe", "0",
                    "-i", intxtpath,
                    "-c", "copy", outfile};

            try {
                ProcessBuilder pb = new ProcessBuilder(incmd);

                pb.redirectErrorStream(true);
                Process process = pb.start();

                System.out.println("Start merge " + outfilename);

                int exitcode = -1;
                while (exitcode != 0) {
                    exitcode = process.waitFor();
                }
                process.destroy();

                System.out.println("finished " + outfilename);
                intxt.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        converTomp4();
    }
}
