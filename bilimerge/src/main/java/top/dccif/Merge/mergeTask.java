package top.dccif.Merge;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;

public class mergeTask implements Callable<Integer> {
    private String infile;
    private String outfile;
    private String outPath;

    public mergeTask(String infile, String outfile, String outPath) {
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
                    exitcode = process.waitFor();
                    while (exitcode != -1) {
                        System.out.println("finished " + outfile);
//                    process.wait(100);
//                process.waitFor();
                        process.destroy();
                        return 0;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override
    public Integer call() {
        return flvtomp4();
    }
}
