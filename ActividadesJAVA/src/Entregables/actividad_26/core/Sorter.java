package Entregables.actividad_26.core;

import Entregables.actividad_26.Utilities.IOManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Sorter {
    public static boolean sort(File Arch1, File Arch2, String path) {

        try {Scanner file1 = new Scanner(Arch1);
            Scanner file2 = new Scanner(Arch2);
            PrintWriter writer = new PrintWriter(new File(path));


            String cage1 = file1.hasNextLine() ? file1.nextLine() : null;
            String cage2 = file2.hasNextLine() ? file2.nextLine() : null;

            process(file1, file2, cage1, cage2, writer);

            writer.close();
            file1.close();
            file2.close();
        } catch(FileNotFoundException e) {
            System.out.println("Error localizado: " + e.getMessage());
            return true;
        }
        return false;
    }

    public static void process(Scanner f1, Scanner f2, String c1, String c2, PrintWriter w){
        int result;

        while (c1 != null || c2 != null) {
            if (c1 != null && c2 != null) {
                result = c1.compareToIgnoreCase(c2);
                if (result < 0) {
                    w.println(c1);
                    c1 = f1.hasNextLine() ? f1.nextLine() : null;
                } else {
                    w.println(c2);
                    c2 = f2.hasNextLine() ? f2.nextLine(): null;
                }
            }
            else if(c1 != null) {
                w.println(c1);
                c1 = f1.hasNextLine() ? f1.nextLine() : null;
            }
            else {
                w.println(c2);
                c2 = f2.hasNextLine() ? f2.nextLine() : null;
            }
        }
    }
}
