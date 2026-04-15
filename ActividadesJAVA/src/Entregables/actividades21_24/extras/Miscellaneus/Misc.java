package Entregables.actividades21_24.extras.Miscellaneus;

import Entregables.actividades21_24.Persona;

import javax.swing.*;

public class Misc {

    public static boolean isInt(String num) {
        if (num == null||num.isEmpty()) return false;
            try {
                Integer.parseInt(num);
                return true;
            } catch (NumberFormatException e) {
                return false;
        }
    }

    public static String entryString(String prompt) {
        String dato = JOptionPane.showInputDialog(null, prompt);

        if (dato == null) {
            return "";
        }
        return dato;
    }

    public static void numChecker(String prompt, Persona p) {
        String input = entryString(prompt);

        while(!isInt(input) || !p.setNumero(Integer.parseInt(input))) {
            JOptionPane.showMessageDialog(null, "Dato erroneo, intentelo de nuevo");
            input = entryString(prompt);
        }
        JOptionPane.showMessageDialog(null,"Dato guardado con exito");
    }
}
