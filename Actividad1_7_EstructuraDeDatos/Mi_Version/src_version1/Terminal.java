import javax.swing.*;
import java.awt.*;

public class Terminal {

    private JTextArea area;
    private JFrame frame;

    // Constructor: Aquí "nace" tu terminal visual
    public Terminal(String title) {
        frame = new JFrame(title);
        area = new JTextArea();
        area.setBackground(Color.BLACK);
        area.setForeground(Color.GREEN);
        area.setEditable(false);
        area.setFont(new Font("Consolas", Font.PLAIN, 22));

        frame.add(new JScrollPane(area));
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    public void imprimir(String content) {
        area.append(content + "\n");
    }


}
