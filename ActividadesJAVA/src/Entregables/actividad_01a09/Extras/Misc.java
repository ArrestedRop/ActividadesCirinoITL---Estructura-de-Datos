package Entregables.actividad_01a09.Extras;

import Entregables.actividad_01a09.Persona;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class Misc {
    private static JOptionPane jOP = new JOptionPane();
    private static String err_msg = "Dato erroneo, por favor intentar de nuevo";
    private static String tru_msg = "Dato guardado con exito";

    public static String fileSearcher() {
        JFileChooser searcher = new JFileChooser();
        String format = "Archivos de datos (.txt, .csv)";

        FileNameExtensionFilter filter = new FileNameExtensionFilter(format, "txt", "csv");
        searcher.setFileFilter(filter);
        searcher.setAcceptAllFileFilterUsed(false);
        int selection  = searcher.showOpenDialog(null);

        if (selection == JFileChooser.APPROVE_OPTION) {
            File file = searcher.getSelectedFile();
            return file.getAbsolutePath();
        }
        else return "";
    }

    public static String entryString(String prompt) {
        String dato = jOP.showInputDialog(null, prompt, "Entrada de datos", jOP.QUESTION_MESSAGE);

        if (dato == null) return "";
        return dato;
    }

    public static double entryDouble(String prompt) {

        while (true) {
            try {
                String input = entryString(prompt);
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                jOP.showMessageDialog(null,err_msg, "Dato Errado", jOP.ERROR_MESSAGE);
            }
        }
    }

    public static void dateChecker(String prompt, Persona p ) {
        String input = entryString(prompt);
        boolean isValid = p.setfecha_nac(input);

        while(!isValid) {
            jOP.showMessageDialog(null, err_msg,"Error", jOP.ERROR_MESSAGE);
            input = entryString(prompt);
            isValid = p.setfecha_nac(input);
        }
        jOP.showMessageDialog(null,tru_msg,"Confirmacion", jOP.OK_OPTION );
    }

    public static void nameChecker(String prompt, Persona p) {
        String input = entryString(prompt);
        boolean isValid = p.setNombre(input);

        while(!isValid) {
            jOP.showMessageDialog(null, err_msg,"Error", jOP.ERROR_MESSAGE);
            input = entryString(prompt);
            isValid = p.setNombre(input);
        }
        jOP.showMessageDialog(null, tru_msg,"Confirmacion", jOP.OK_OPTION );
    }

    public static void heightChecker(String prompt, Persona p) {
        double input = entryDouble(prompt);
        boolean isValid = p.setEstatura(input);

        while(!isValid) {

            jOP.showMessageDialog(null, err_msg,"Error", jOP.ERROR_MESSAGE);
            input = entryDouble(prompt);
            isValid = p.setEstatura(input);
        }
        jOP.showMessageDialog(null,tru_msg,"Confirmacion", jOP.OK_OPTION );
    }

    public static void weigthChecker(String prompt, Persona p) {
        double input = entryDouble(prompt);
        boolean isValid = p.setPeso(input);

        while(!isValid) {
            jOP.showMessageDialog(null, err_msg,"Error", jOP.ERROR_MESSAGE);
            input = entryDouble(prompt);
            isValid = p.setPeso(input);
        }
        jOP.showMessageDialog(null, tru_msg,"Confirmacion", jOP.OK_OPTION );
    }
    public static void numChecker(String prompt, Persona p) {
        String input = entryString(prompt);
        boolean isValid = p.setNum_con(input);

        while(!isValid) {
            jOP.showMessageDialog(null, err_msg,"Error", jOP.ERROR_MESSAGE);
            input = entryString(prompt);
            isValid = p.setNum_con(input);
        }
        jOP.showMessageDialog(null,tru_msg,"Confirmacion", jOP.OK_OPTION );
    }
    public static boolean isInt(String num) {
    if (num == null||num.isEmpty()) return false;
    else return true;
    }
}




