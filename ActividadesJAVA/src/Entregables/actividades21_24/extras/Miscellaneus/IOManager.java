package Entregables.actividades21_24.extras.Miscellaneus;

import Entregables.actividades21_24.Persona;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import static Entregables.actividades21_24.extras.Miscellaneus.Misc.isInt;

public class IOManager {
    public static String fileSearcher() {
        JFileChooser searcher = new JFileChooser();
        String format = "Archivos de datos (.txt, .csv)";
        FileNameExtensionFilter filter = new FileNameExtensionFilter(format,
                                    "txt", "csv");
        int selection = searcher.showOpenDialog(null);

        searcher.setFileFilter(filter);
        searcher.setAcceptAllFileFilterUsed(false);
        if (selection == JFileChooser.APPROVE_OPTION) {
            File file = searcher.getSelectedFile();

            return file.getAbsolutePath();
        } else return "";
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