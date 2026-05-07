package Entregables.actividad_01a09.Regis;

import Entregables.actividad_01a09.Persona;
import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class RegistroArchivo {
    private int cuenta = 0;

    public Persona[] data(String archiv) {
        int totalLines = 0;
        this.cuenta = 0; // Reiniciamos el contador cada vez que se llama al método

        try {
            File f = new File(archiv);
            if (!f.exists()) {
                JOptionPane.showMessageDialog(null, "El archivo no existe en la ruta: " + f.getAbsolutePath());
                return null;
            }
            Scanner contador = new Scanner(f);
            while (contador.hasNextLine()) {
                contador.nextLine();
                totalLines++;
            }
            contador.close();
            Persona[] grupo = new Persona[totalLines];
            Scanner lector = new Scanner(f);

            while (lector.hasNextLine()) {
                String lineaActual = lector.nextLine();

                // Saltamos líneas vacías para evitar errores
                if (lineaActual.trim().isEmpty()) continue;
                String[] info = lineaActual.split("\\|");

                // Verificamos que la línea tenga las 5 columnas esperadas
                if (info.length >= 5) {
                    try {
                        Persona nPersona = new Persona();
                        boolean d1 = nPersona.setNombre(info[0].trim());
                        boolean d2 = nPersona.setNum_con(info[1].trim());
                        boolean d3 = nPersona.setfecha_nac(info[2].trim());
                        boolean d4 = nPersona.setPeso(Double.parseDouble(info[3].trim()));
                        boolean d5 = nPersona.setEstatura(Double.parseDouble(info[4].trim()));

                        if (d1 && d2 && d3 && d4 && d5) {
                            grupo[this.cuenta] = nPersona;
                            this.cuenta++;
                        } else {
                            System.out.println("Línea ignorada por validación fallida: " + info[0]);
                        }
                    } catch (NumberFormatException nfe) {
                        System.out.println("Error en formato de número (Peso/Estatura): " + nfe.getMessage());
                    }
                }
            }
            lector.close();

            // Opcional: Si hubo líneas basura, redimensionamos para no devolver nulos
            if (this.cuenta < totalLines) {
                Persona[] grupoLimpio = new Persona[this.cuenta];
                System.arraycopy(grupo, 0, grupoLimpio, 0, this.cuenta);
                return grupoLimpio;
            }

            return grupo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al procesar el archivo: " + e.getMessage());
            e.printStackTrace(); // Esto te ayuda a ver el error real en la terminal
            return null;
        }
    }

    public int getCuenta() {
        return this.cuenta;
    }
}