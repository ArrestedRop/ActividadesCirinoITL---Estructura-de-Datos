package Entregables.actividades21_26.actividad22.core;

import Entregables.actividad_27.Utilities.Misc;
import Entregables.actividades21_26.actividad24.Core.Persona;

public class RegistroManual {
    private int cuenta = 0;

    public Entregables.actividades21_26.actividad22.core.Persona[] dataManual() {
        cuenta = 0;
        Entregables.actividades21_26.actividad24.Core.Persona[] grupo = new Entregables.actividades21_26.actividad24.Core.Persona[25];
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

    private Entregables.actividades21_26.actividad24.Core.Persona crearPersona(String nom) {
        Entregables.actividades21_26.actividad24.Core.Persona p = new Entregables.actividades21_26.actividad24.Core.Persona();
        Misc.numChecker("De # de control: ",p);
        p.setNombre(nom);
        return p;
    }

    private Entregables.actividades21_26.actividad24.Core.Persona[] truncarArreglo(Entregables.actividades21_26.actividad24.Core.Persona[] original, int cantidadReal) {
        Entregables.actividades21_26.actividad24.Core.Persona[] limpio = new Persona[cantidadReal];
        System.arraycopy(original, 0, limpio, 0, cantidadReal);
        return limpio;
    }
}