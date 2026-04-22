package Entregables.actividades21_24.actividad24.Core;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RegistroArchivo {
    private int cuenta = 0;

    public Persona[] dataArchivo(String archiv) {
        int totalLines;

        try {
            totalLines = lineCounter(archiv);
            this.cuenta = 0;

            Persona[] grupo = creator(archiv, totalLines);

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

    private Persona[] creator(String archiv, int totalLines) throws FileNotFoundException {
        Persona[] grupo = new Persona[totalLines];
        Scanner lector = new Scanner(new File(archiv));

        while (lector.hasNextLine()) {
            String lineaActual = lector.nextLine();
            String[] info = lineaActual.split(",");

            if (info.length >= 2) {
                Persona nPersona = new Persona();
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

    private Persona[] truncarArreglo(Persona[] original, int cantidadReal) {
        Persona[] limpio = new Persona[cantidadReal];
        System.arraycopy(original, 0, limpio, 0, cantidadReal);
        return limpio;
    }
}

