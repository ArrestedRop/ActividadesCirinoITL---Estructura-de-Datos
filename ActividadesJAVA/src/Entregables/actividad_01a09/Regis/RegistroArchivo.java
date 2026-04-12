package Entregables.actividad_01a09.Regis;

import Entregables.actividad_01a09.Persona;

import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class RegistroArchivo {
    private int cuenta = 0;

    public Persona[] data(String archiv) {
        int totalLines = 0;

        //Ya que no se puede usar de momento un ArrayList<>
        // intento crear el arreglo con la cantidad de lineas del archivo de texto
        //AVISO, CAMBIAR EL FORMATO DE TXT A CSV
        try {
            Scanner contador = new Scanner(new File(archiv));
            while (contador.hasNextLine()) {
                contador.nextLine();
                totalLines++;
            }
            contador.close();

            Persona[] grupo = new Persona[totalLines];
            Scanner lector = new Scanner(new File(archiv));
            while (lector.hasNextLine()) {
                String lineaActual = lector.nextLine();
                String[] info = lineaActual.split("\\|");

                Persona nPersona = new Persona();
                boolean d1 = nPersona.setNombre(info[0]);
                boolean d2 =  nPersona.setNum_con(info[1]);
                boolean d3 = nPersona.setfecha_nac(info[2]);
                boolean d4 = nPersona.setPeso(Double.parseDouble(info[3]));
                boolean d5 = nPersona.setEstatura(Double.parseDouble(info[4]));
            //Si un solo dato es invalido, se toma como basura
               if (d1 && d2&& d3&& d4&& d5) {
                   grupo[this.cuenta] = nPersona;
                   this.cuenta++;
               }
            }
            lector.close();
            return grupo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al procesar el archivo"+ e.getMessage());
            return null;
        }
    }
    public int getCuenta() {
        return this.cuenta;
    }
}

