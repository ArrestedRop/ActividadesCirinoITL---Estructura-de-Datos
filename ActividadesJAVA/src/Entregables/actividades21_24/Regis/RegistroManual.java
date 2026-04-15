package Entregables.actividades21_24.Regis;

import Entregables.actividades21_24.Persona;
import Entregables.actividades21_24.extras.Miscellaneus.Misc;

import javax.swing.*;

public class RegistroManual {
    private int cuenta = 0;

    public Persona[] dataManual() {
        cuenta = 0;
        Persona[] grupo = new Persona[25];
        String nom;

        nom = Misc.entryString("Proporcione el nom de la persona " +(cuenta+1)+
                               "o escriba \"fin\" para terminar");

        while (!nom.equalsIgnoreCase("fin")  && this.cuenta < grupo.length) {
            grupo[cuenta] = crearPersona(nom);
            this.cuenta++;
            JOptionPane.showMessageDialog(null,
                    "Persona registrada con exito");

                if (cuenta < grupo.length) {
                nom = Misc.entryString("Proporcione el nom de la persona " +(cuenta+1)+
                        "o escriba \"fin\" para terminar");
                }
            }
    return grupo;
    }

    public int getCuenta() {
        return this.cuenta;
    }
    private Persona crearPersona(String nom) {
        Persona p = new Persona();
        Misc.numChecker("De # de control: ",p);
        return p;
    }
}
