package Entregables.actividad_01a09.Regis;

import Entregables.actividad_01a09.Extras.Misc;
import Entregables.actividad_01a09.Persona;

import javax.swing.*;

public class RegistroManual {
    private int cuenta = 0;
    private JOptionPane jOP = new JOptionPane();

    public Persona[] data() {
        cuenta = 0;
        Persona[] grupo = new Persona[25];
        String nom;

        nom = Misc.entryString("Proporcione el nom de la persona " +(cuenta+1)+ " o escriba \"fin\" para terminar");

        while (!nom.equalsIgnoreCase("fin") && this.cuenta < grupo.length) {
            grupo[cuenta] = crearPersona(nom);
            this.cuenta++;
            jOP.showMessageDialog(null, "Entregables.tarea_01.Persona registrada con exito");

                if (cuenta < grupo.length)
                nom = Misc.entryString("Proporcione el nom de la persona " +(cuenta+1)+ "o escriba \"fin\" para terminar");
            }
    return grupo;
    }
    public int getCuenta() {
        return this.cuenta;
    }
    private Persona crearPersona(String nom) {
        Persona p = new Persona();

        Misc.numChecker("De # de control: ",p);
        Misc.dateChecker("De Fecha de Nacimiento:",p);
        Misc.weigthChecker("Peso de la persona:",p);
        Misc.heightChecker("Estatura de la persona:",p);
        return p;
    }
}
