import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class RegistroArchivo {
    private int cuenta = 0;

    public Persona[] data(String archiv) {
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
            while (lector.hasNextLine()) {
                String lineaActual = lector.nextLine();

                String[] info = lineaActual.split("\\|");
                Persona nPersona = new Persona();
                nPersona.setNombre(info[0]);
                nPersona.setNum_con(info[1]);
                nPersona.setfecha_nac(info[2]);
                nPersona.setPeso(Double.parseDouble(info[3]));
                nPersona.setEstatura(Double.parseDouble(info[4]));
                grupo[this.cuenta] = nPersona;

                this.cuenta++;
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

