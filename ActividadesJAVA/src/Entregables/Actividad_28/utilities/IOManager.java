package Entregables.Actividad_28.utilities;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

import static Entregables.actividad_27.Utilities.Misc.isInt;

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