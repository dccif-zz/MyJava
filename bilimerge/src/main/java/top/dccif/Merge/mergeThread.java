package top.dccif.Merge;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class mergeThread implements Runnable {
    private String infile;
    private String outfile;
    private String outPath;

    public mergeThread(String infile, String outfile, String outPath) {
        this.infile = infile;
        this.outfile = outfile;
        this.outPath = outPath;
    }

    private int flvtomp4() {
        File intxt = new File(infile + "\\input.txt");
        int exitcode = -1;
        if (intxt.exists()) {
            String input = intxt.getAbsolutePath();

//            String[] outname = infile.getName().split("_");
//            String outfile = outname[0] + "_" + outname[1] + ".mp4";
            String outfilepath = outPath + "\\" + outfile;

            String[] incmd = {"ffmpeg.exe",
                    "-loglevel", "quiet",
                    "-f", "concat",
                    "-safe", "0",
                    "-i", input,
                    "-c", "copy", outfilepath};

            try {
                ProcessBuilder pb = new ProcessBuilder(incmd);
//                Process process = Runtime.getRuntime().exec(incmd);

                pb.redirectErrorStream(true);
                Process process = pb.start();
                try (BufferedReader br = new BufferedReader(
                        new InputStreamReader(process.getInputStream()))) {
                    String out = null;
                    while ((out = br.readLine()) != null) {
                        System.out.println(out);
                    }
                    System.out.println("Start merge " + outfile);
                    while (exitcode != 0) {
                        exitcode = process.waitFor();
//                        process.wait(100);
//                        process.waitFor();
                    }
                    process.destroy();
                    System.out.println("finished " + outfile);
                }
                return 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override
    public void run() {
        flvtomp4();
    }
}
