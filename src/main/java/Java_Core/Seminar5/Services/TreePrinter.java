package Java_Core.Seminar5.Services;

import java.io.File;

public class TreePrinter {
    public static void printTree(File file, String indent, boolean isLast){
        System.out.print(indent);
        if (isLast){
            System.out.print("└─");
            indent += "  ";
        }
        else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();

        int subDirTotal = 0;
        for (int i = 0; i < files.length; i++){
            if (files[i].isDirectory())
            {
                subDirTotal++;
            }
        }

        int subDirCounter = 0;
        for (int i = 0; i < files.length; i++){
            if (files[i].isDirectory())
            {
                printTree(files[i], indent, subDirTotal == ++subDirCounter);
            } else if (files[i].isFile()){
                System.out.print(indent);
                System.out.println("---" + files[i].getName());
            }
        }
    }
}
