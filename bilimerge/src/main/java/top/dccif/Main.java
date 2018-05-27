package top.dccif;

import top.dccif.Merge.PathTool;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void printhelp() {
        System.out.println("必须两个参数，第一个为目录，结尾不要有\\，第二个参数为输出目录，同样结尾不要有\\");
        System.out.println("Such merge C:\\Down\\182323  C:\\Out\\YouDir");
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

        PathTool my = new PathTool();

        List<File> files;
        files = my.getPathAndGen(args[0], args[1]);

        my.fileDelete(files);
    }
}
