package Entregables.actividades21_24.actividad24.Core;

import Entregables.actividad_26.Utilities.Misc;

public class RegistroManual {
    private int cuenta = 0;

    public Persona[] dataManual() {
        cuenta = 0;
        Persona[] grupo = new Persona[25];
        String nom;

        nom = Misc.entryString("Proporcione el nom de la persona " +(cuenta+1)+
                               "o escriba \"fin\" para terminar");

// Cambia tu condición del while por esto:
        while (nom != null && !nom.equalsIgnoreCase("fin") && this.cuenta < grupo.length) {
            {
                grupo[cuenta] = crearPersona(nom);
                this.cuenta++;

                if (cuenta < grupo.length) {
                    nom = Misc.entryString("Proporcione el nom de la persona " + (cuenta + 1) +
                            "o escriba \"fin\" para terminar");
                }
            }
        }
    return truncarArreglo(grupo, this.cuenta);
    }

    private Persona crearPersona(String nom) {
        Persona p = new Persona();
        Misc.numChecker("De # de control: ",p);
        p.setNombre(nom);
        return p;
    }

    private Persona[] truncarArreglo(Persona[] original, int cantidadReal) {
        Persona[] limpio = new Persona[cantidadReal];
        System.arraycopy(original, 0, limpio, 0, cantidadReal);
        return limpio;
    }
}