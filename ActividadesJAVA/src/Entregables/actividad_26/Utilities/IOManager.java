package Entregables.actividad_26.Utilities;

import Entregables.actividades21_24.actividad24.Core.Persona;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import static Entregables.actividad_26.Utilities.Misc.isInt;

public class IOManager {
    public static String fileSearcher() {
        JFileChooser searcher = new JFileChooser();
        String format = "Archivos de datos (.txt, .csv)";
        FileNameExtensionFilter filter = new FileNameExtensionFilter(format,"txt", "csv");

        searcher.setFileFilter(filter);
        searcher.setAcceptAllFileFilterUsed(true);
        int selection = searcher.showOpenDialog(null);

        if (selection == JFileChooser.APPROVE_OPTION) {
            File file = searcher.getSelectedFile();
                return (file != null) ? file.getAbsolutePath() : "";
        }
        return "";
    }

    public static void fileWritter(String path, Persona[] grupo) {
        JOptionPane jop = new JOptionPane();
        String msg = "Archivo generado exitosamente en:\n";

        try (PrintWriter writer = new PrintWriter(new File(path))) {
            for (Persona p : grupo)
                if (p != null) writer.println(p.getNumero() + "," + p.getNombre());
            jop.showMessageDialog(null, msg + path);
        } catch (IOException e) {
            jop.showMessageDialog(null, "Error: " + e.getMessage());
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void fileWritter(String path, String data) {
        JOptionPane jop = new JOptionPane();
        String msg = "Archivo generado exitosamente en:\n";

        try (PrintWriter writer = new PrintWriter(new File(path))) {
                if (data != null) writer.println(data);
            jop.showMessageDialog(null, msg + path);
        } catch (IOException e) {
            jop.showMessageDialog(null, "Error: " + e.getMessage());
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static int menuCreator(StringBuilder msg, int quantity) {
        String opcion;
        int op;

        do {
            opcion = JOptionPane.showInputDialog(null, msg);
            if (opcion == null) return quantity;
            if (isInt(opcion)) {
                op = Integer.parseInt(opcion);
                if (op >= 1 && op <= quantity) return op;
            }
        } while (true);
    }
}