import javax.swing.*;
import java.util.Scanner;

public class Sail {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Se instancian cada una de las clases
        RegistroManual regisMan = new RegistroManual();
        RegistroArchivo regisArc = new RegistroArchivo();
        Busqueda buscador = new Busqueda();
        ImpresionIndividual imprimir = new ImpresionIndividual();
        ImpresionLista lista = new ImpresionLista();

        int opt;
        int cuenta = 0;
        Persona[] grupo = null;
        String menu = "\n--- MENU DE GESTIÓN (5.0 SAIL) ---\n" +
                "___________________________________________\n"+
                "1. Introducir datos de personas por teclado\n" +
                "2. Leer datos de un archivo de texto\n" +
                "3. Buscar alguna persona por nombre\n" +
                "4. Imprimir lista completa\n" +
                "5. Salir\n" +
                "___________________________________________\n"+
                "Selecciona una opcion: ";

        do{
            try {
            JOptionPane.showInputDialog(menu);
                opt = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e){
                opt = 0;
        }

            switch (opt) {
                case 1 -> {
                    grupo = regisMan.data();
                    cuenta = regisMan.getCuenta();
                    System.out.println("Cantidad de datos cargados: " + cuenta);
                }
                case 2 -> {
                    String filePath = Misc.fileSearcher();
                    if (!filePath.isEmpty()) {
                    grupo = regisArc.data(filePath);
                    cuenta = regisArc.getCuenta();
                    JOptionPane.showMessageDialog
                            (null, "Cantidad de datos cargados: " + cuenta,
                                    "Carga exitosa", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                case 3 -> {
                    System.out.println("Otorgue el nombre a buscar: ");
                    String nombre = scan.nextLine();
                    int pos = buscador.search(nombre, grupo, cuenta);
                    int compara  = buscador.getCompara();
                    imprimir.outs(pos, compara, grupo,nombre);
                }
                case 4 -> {
                    System.out.println("Impresion por medio de la lista");
                    lista.list(grupo);
                }
                case 5 -> System.out.println("Saliendo...");
            }
        }while(opt!=5);
    }
}
