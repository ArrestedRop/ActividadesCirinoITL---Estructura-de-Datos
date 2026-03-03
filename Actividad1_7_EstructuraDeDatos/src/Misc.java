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
        JOptionPane.showMessageDialog(null,
                "Dato guardado con exito","Confirmacion", JOptionPane.OK_OPTION );
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




}



