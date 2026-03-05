package Entregables.actividad_01a09.Extras;

import Entregables.actividad_01a09.Persona;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class Misc {

    public static String fileSearcher() {
        JFileChooser searcher = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter
                ("Archivos de datos (.txt, .csv)", "txt", "csv");
        searcher.setFileFilter(filter);
        searcher.setAcceptAllFileFilterUsed(false);
        int selection  = searcher.showOpenDialog(null);
        if (selection == JFileChooser.APPROVE_OPTION) {
            File file = searcher.getSelectedFile();
            return file.getAbsolutePath();
        }
        else
            return "";
    }

    public static String entryString(String prompt) {
        String dato = JOptionPane.showInputDialog(null, prompt,
                "Entrada de datos", JOptionPane.QUESTION_MESSAGE);

        if (dato == null) {
            return "";
        }
        return dato;
    }

    public static double entryDouble(String prompt) {
        while (true) {
            try {
                String input = entryString(prompt);
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Dato erroneo, " +
                                "por favor intentar de nuevo",
                        "Dato Errado", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void dateChecker(String prompt, Persona p ) {
        String input = entryString(prompt);
        boolean isValid = p.setfecha_nac(input);

        while(!isValid) {
            JOptionPane.showMessageDialog(null, "Dato erroneo," +
                " intentelo de nuevo","Error", JOptionPane.ERROR_MESSAGE);
            input = entryString(prompt);
            isValid = p.setfecha_nac(input);
        }

        JOptionPane.showMessageDialog(null,
                "Dato guardado con exito","Confirmacion", JOptionPane.OK_OPTION );
    }

    public static void nameChecker(String prompt, Persona p) {
        String input = entryString(prompt);
        boolean isValid = p.setNombre(input);

        while(!isValid) {
            JOptionPane.showMessageDialog(null, "Dato erroneo," +
                    " intentelo de nuevo","Error", JOptionPane.ERROR_MESSAGE);
            input = entryString(prompt);
            isValid = p.setNombre(input);
        }
        JOptionPane.showMessageDialog(null,
                "Dato guardado con exito","Confirmacion", JOptionPane.OK_OPTION );
    }

    public static void heightChecker(String prompt, Persona p) {
        double input = entryDouble(prompt);
        boolean isValid = p.setEstatura(input);

        while(!isValid) {
            JOptionPane.showMessageDialog(null, "Dato erroneo," +
                    " intentelo de nuevo","Error", JOptionPane.ERROR_MESSAGE);
            input = entryDouble(prompt);
            isValid = p.setEstatura(input);
        }
        JOptionPane.showMessageDialog(null,
                "Dato guardado con exito","Confirmacion", JOptionPane.OK_OPTION );
    }

    public static void weigthChecker(String prompt, Persona p) {
        double input = entryDouble(prompt);
        boolean isValid = p.setPeso(input);

        while(!isValid) {
            JOptionPane.showMessageDialog(null, "Dato erroneo," +
                    " intentelo de nuevo","Error", JOptionPane.ERROR_MESSAGE);
            input = entryDouble(prompt);
            isValid = p.setPeso(input);
        }
        JOptionPane.showMessageDialog(null,
                "Dato guardado con exito","Confirmacion", JOptionPane.OK_OPTION );
    }
    public static void numChecker(String prompt, Persona p) {
        String input = entryString(prompt);
        boolean isValid = p.setNum_con(input);

        while(!isValid) {
            JOptionPane.showMessageDialog(null, "Dato erroneo," +
                    " intentelo de nuevo","Error", JOptionPane.ERROR_MESSAGE);
            input = entryString(prompt);
            isValid = p.setNum_con(input);
        }
        JOptionPane.showMessageDialog(null,
                "Dato guardado con exito","Confirmacion", JOptionPane.OK_OPTION );
    }
}



