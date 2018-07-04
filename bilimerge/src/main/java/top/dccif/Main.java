package top.dccif;

import top.dccif.cmdparams.Cmdparam;
import top.dccif.convert.Convert;
import top.dccif.utilTools.PathTool;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void printhelp() {
        System.out.println("必须两个参数，第一个为目录，第二个参数为输出目录");
        System.out.println("Such merge C:\\Down\\182323[\\]  C:\\Out\\YouDir[\\]");
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (args.length != 2) {
            System.out.println("Error Syntax");
            System.out.println("must 2 args first is the directory , second is the out");
            printhelp();
            System.out.println("-h 参数查看帮助");
//            String[] out2 = sc.nextLine().split("\\s+");
            args = sc.nextLine().split("\\s+");
        }

        Cmdparam inputPath = new Cmdparam(args[0], args[1]);

        PathTool tools = new PathTool(inputPath);

        List<File> files = tools.getPathAndGen();
        List<Convert> cv = tools.getConvertTaskList();

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(cv.size());
        for (Convert c : cv) {
            fixedThreadPool.submit(c);
        }

//        cv.stream().map(((Function<Convert, Object>) fixedThreadPool::submit));
//        top.dccif.Merge.PathTool my = new top.dccif.Merge.PathTool();
//        files = my.getPathAndGen(args[0], args[1]);
//        my.fileDelete(files);

        // 收尾处理
        fixedThreadPool.shutdown();
        sc.close();
    }
}
