package tarea_03;
import java.util.Scanner;

public class Misc {
    static Scanner sc = new Scanner(System.in);

    public static boolean isInt(String num) {
        if (num == null||num.isEmpty()) return false;
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int menuCreator(String msg, int op) {
        int selection;
        String option;
        String e = "Opción fuera de rango. Elige un número del 0 a " + op+"\n";

        do {
            do {
                System.out.print(msg+"> ");
                option = sc.nextLine();
            }while(!Misc.isInt(option));
            selection = Integer.parseInt(option);

            if (selection > op || selection < 0) System.out.println(e);
        }while(selection > op || selection < 0);
        return selection;
    }
}
