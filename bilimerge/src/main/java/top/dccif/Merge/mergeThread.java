package top.dccif.Merge;

import java.io.File;

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


                Process process = pb.start();

                System.out.println("Start merge " + outfile);
                process.waitFor();
                System.out.println("finished " + outfile);
//                    process.wait(100);
//                    process.waitFor();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public void run() {
        flvtomp4();
    }
}
