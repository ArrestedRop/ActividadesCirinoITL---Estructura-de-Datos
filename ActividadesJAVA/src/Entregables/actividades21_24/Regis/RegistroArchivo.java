package Entregables.actividades21_24.Regis;

import Entregables.actividades21_24.Persona;
import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class RegistroArchivo {
    private int cuenta = 0;

    public Persona[] dataArchivo(String archiv) {
        int totalLines = 0;

        try {
            Scanner contador = new Scanner(new File(archiv));
            while (contador.hasNextLine()) {
                contador.nextLine();
                totalLines++;
            }
            contador.close();

            Persona[] grupo = new Persona[totalLines];
            Scanner lector = new Scanner(new File(archiv));
            this.cuenta = 0;

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

            return truncarArreglo(grupo, this.cuenta);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al procesar el archivo"+ e.getMessage());
            return null;
        }
    }
    public int getCuenta() {
        return this.cuenta;
    }

    private Persona[] truncarArreglo(Persona[] original, int cantidadReal) {
        Persona[] limpio = new Persona[cantidadReal];
        System.arraycopy(original, 0, limpio, 0, cantidadReal);
        return limpio;
    }
}

