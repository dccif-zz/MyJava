package dccif.top;

import dccif.top.Merge.PathTool;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        while (args.length != 3) {
//            System.out.println("Error Syntax");
//            System.out.println("must 2 args first is the Directory second is the out");
//        }

        PathTool my = new PathTool();

        ArrayList<String> files = new ArrayList<>();

        files = my.getPath(args[0],args[1]);

        System.out.print(files);
    }
}
