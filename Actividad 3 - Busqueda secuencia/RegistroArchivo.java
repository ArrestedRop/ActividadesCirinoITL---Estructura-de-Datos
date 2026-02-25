import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RegistroArchivo {
    private int cuenta = 0;
    public Persona[] data(String archiv) {

        int totalLines = 0;

        // ==========================================
        //Chequeo de la cantidad de lineas que hay en el arreglo para poder determinar el tama;o del arreglo
        //Puede ser cambiado perfectamente por un ArrayList<>
        // ==========================================
        try {
            Scanner contador = new Scanner(new File(archiv));
            while (contador.hasNextLine()) {
                contador.nextLine();
                totalLines++;
            }
            contador.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Documento de texto no encontrado.");
            return null;
        }

        // ==========================================
        //Creacion del arreglo
        // ==========================================
        Persona[] grupo = new Persona[totalLines];

        // ==========================================
        //Parte de la clase que se encarga de leer el contenido una vez el arreglo exista con su tama;o deseado
        // ==========================================
        try {
        Scanner lector = new Scanner(new File(archiv));

            while (lector.hasNextLine()) {
                String lineaActual = lector.nextLine();
                String[] informacionFraccionada = lineaActual.split("\\|");

                Persona nuevaPersona = new Persona();
                nuevaPersona.setNombre(informacionFraccionada[0]);
                nuevaPersona.setNumero_de_control(Integer.parseInt(informacionFraccionada[1]));
                nuevaPersona.setFecha_de_nacimiento(informacionFraccionada[2]);
                nuevaPersona.setPeso(Double.parseDouble(informacionFraccionada[3]));
                nuevaPersona.setEstatura(Double.parseDouble(informacionFraccionada[4]));

                grupo[this.cuenta] = nuevaPersona;
                this.cuenta++;
            }
        lector.close();

        } catch(FileNotFoundException e) {
            System.out.println("Error al buscar el dato");
            return null;
        }
        return grupo;
    }

    public int getCuenta() {
        return this.cuenta;
    }

}
