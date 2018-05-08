package top.dccif;

import top.dccif.Merge.PathTool;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        while (args.length != 2) {
            System.out.println("Error Syntax");
            System.out.println("must 2 args first is the Directory second is the out");
            System.out.println("Such merge C:\\Down\\182323  C:\\Out\\YouDir");
        }

        PathTool my = new PathTool();

        List<File> files = new ArrayList<>();

        files = my.getPathAndGen(args[0], args[1]);

//        new mergeThread(files.get(0),args[1]).run();
//        new mergeThread(files.get(1),args[1]).run();
//        new mergeThread(files.get(2),args[1]).run();
//        new mergeThread(files.get(3),args[1]).run();
//        new mergeThread(files.get(4),args[1]).run();

//        System.out.print(files);
        my.fileDelete(files);
    }
}
