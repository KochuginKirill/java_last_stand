package Java_Core.Seminar5;

import Java_Core.Seminar5.Services.Copy;

import java.io.File;
import java.io.IOException;

import static Java_Core.Seminar5.Services.TreePrinter.printTree;


public class Main {
    public static void main(String[] args) {
        Copy copy = new Copy();
        try {
            copy.copyFilesAndFolders(new File("./src/main/java/Java_Core/Seminar5/FilesFrom"),
                    new File("./src/main/java/Java_Core/Seminar5/FilesWhere"));
        } catch (IOException io){
            io.printStackTrace();
        }

        printTree(new File("./src"), "", true);
    }
}
