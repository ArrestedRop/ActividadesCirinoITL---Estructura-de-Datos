package Entregables.actividad_01a09.Regis;

import Entregables.actividad_01a09.Persona;
import javax.swing.JOptionPane;
import java.io.File;
import java.util.Scanner;

public class RegistroArchivo {
    private int cuenta = 0;

    public Persona[] data(String archiv) {
        this.cuenta = 0; // REINICIO VITAL para cada carga de archivo
        int totalLines = 0;

        try {
            Scanner contador = new Scanner(new File(archiv));
            while (contador.hasNextLine()) {
                String l = contador.nextLine();
                if (l != null && !l.trim().isEmpty()) {
                    totalLines++;
                }
            }
            contador.close();

            Persona[] grupo = new Persona[totalLines];

            Scanner lector = new Scanner(new File(archiv));
            while (lector.hasNextLine()) {
                String lineaActual = lector.nextLine();
                if (lineaActual == null || lineaActual.trim().isEmpty()) continue;
                String[] info = lineaActual.split(",");

                if (info.length >= 5) {
                    Persona nPersona = new Persona();
                    boolean d1 = nPersona.setNombre(info[0].trim());
                    boolean d2 = nPersona.setNum_con(info[1].trim());
                    boolean d3 = nPersona.setfecha_nac(info[2].trim());
                    boolean d4 = nPersona.setPeso(Double.parseDouble(info[3].trim()));
                    boolean d5 = nPersona.setEstatura(Double.parseDouble(info[4].trim()));

                    if (d1 && d2 && d3 && d4 && d5) {
                        grupo[this.cuenta] = nPersona;
                        this.cuenta++;
                    }
                }
            }
            lector.close();
            return grupo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error en archivo: " + e.getMessage());
            return null;
        }
    }

    public int getCuenta() {
        return this.cuenta;
    }
}
