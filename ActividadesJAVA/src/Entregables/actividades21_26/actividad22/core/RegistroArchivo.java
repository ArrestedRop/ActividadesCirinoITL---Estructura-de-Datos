package Entregables.actividades21_26.actividad22.core;

import Entregables.actividades21_26.actividad24.Core.Persona;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RegistroArchivo {
    private int cuenta = 0;

    public Entregables.actividades21_26.actividad22.core.Persona[] dataArchivo(String archiv) {
        int totalLines;

        try {
            totalLines = lineCounter(archiv);
            this.cuenta = 0;

            Entregables.actividades21_26.actividad24.Core.Persona[] grupo = creator(archiv, totalLines);

            return truncarArreglo(grupo, this.cuenta);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al procesar el archivo"+ e.getMessage());
            return null;
        }
    }

    private int lineCounter(String archiv) throws FileNotFoundException {
        int totalLines = 0;

        Scanner contador = new Scanner(new File(archiv));
        while (contador.hasNextLine()) {
            contador.nextLine();
            totalLines++;
        }
        contador.close();
        return totalLines;
    }

    private Entregables.actividades21_26.actividad24.Core.Persona[] creator(String archiv, int totalLines) throws FileNotFoundException {
        Entregables.actividades21_26.actividad24.Core.Persona[] grupo = new Entregables.actividades21_26.actividad24.Core.Persona[totalLines];
        Scanner lector = new Scanner(new File(archiv));

        while (lector.hasNextLine()) {
            String lineaActual = lector.nextLine();
            String[] info = lineaActual.split(",");

            if (info.length >= 2) {
                Entregables.actividades21_26.actividad24.Core.Persona nPersona = new Entregables.actividades21_26.actividad24.Core.Persona();
                boolean d1 = nPersona.setNumero(Integer.parseInt(info[0]));
                boolean d2 = nPersona.setNombre(info[1]);

                //Si un solo dato es invalido, se toma como basura
                if (d1 && d2) {
                    grupo[this.cuenta] = nPersona;
                    this.cuenta++;
                }
            }
        }
        lector.close();
        return grupo;
    }

    private Entregables.actividades21_26.actividad24.Core.Persona[] truncarArreglo(Entregables.actividades21_26.actividad24.Core.Persona[] original, int cantidadReal) {
        Entregables.actividades21_26.actividad24.Core.Persona[] limpio = new Persona[cantidadReal];
        System.arraycopy(original, 0, limpio, 0, cantidadReal);
        return limpio;
    }
}

