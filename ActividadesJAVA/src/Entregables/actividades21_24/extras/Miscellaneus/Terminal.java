package Entregables.actividades21_24.extras.Miscellaneus;

import javax.swing.*;
import java.awt.*;

public class Terminal {

    private JTextArea area;
    private JFrame frame;

    // Constructor: Aquí "nace" tu terminal visual
    public Terminal(String title) {
        frame = new JFrame(title);
        area = new JTextArea();
        area.setBackground(Color.WHITE);
        area.setForeground(Color.BLUE);
        area.setEditable(false);
        area.setFont(new Font("Terminal", Font.PLAIN, 22));

        frame.setLocationRelativeTo(null);
        frame.add(new JScrollPane(area));
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    public void imprimir(String content) {
        area.append(content + "\n");
    }

}

