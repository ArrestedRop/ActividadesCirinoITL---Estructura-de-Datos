import java.util.Scanner;

public class Sail {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Se instancian cada una de las clases
        RegistroManual registroManual = new RegistroManual();
        RegistroArchivo registroArchivo = new RegistroArchivo();
        Busqueda buscador = new Busqueda();
        Impresion imprimir = new Impresion();

        int opciones;
        int cuenta = 0;
        Persona[] grupo = null;
        String menu = "\n--- MENU DE GESTIÓN (5.0 SAIL) ---\n" +
                "___________________________________________\n"+
                "1. Introducir datos de personas por teclado\n" +
                "2. Leer datos de un archivo de texto\n" +
                "3. Buscar alguna persona por nombre\n" +
                "4. Salir\n" +
                "___________________________________________\n"+
                "Selecciona una opcion: ";

    do{
        System.out.println(menu);
        try {
            opciones = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e){
            opciones = 0;
        }

        switch (opciones) {
            case 1:
                grupo = registroManual.data();
                cuenta = registroManual.getCuenta();
                System.out.println("Cantidad de datos cargados: " + cuenta);
                break;

            case 2:
                System.out.println("Otorgue la ruta del archivo .txt");
                String rutaArchivo = scan.nextLine();
                grupo = registroArchivo.data(rutaArchivo);
                cuenta = registroArchivo.getCuenta();
                System.out.println("Cantidad de datos cargados: " + cuenta);
                break;

            case 3:
                System.out.println("Otorgue el nombre a buscar: ");
                String nombre = scan.nextLine();
                int pos = buscador.search(nombre, grupo, cuenta);
                int compara  = buscador.getCompara();
                imprimir.outs(pos, compara, grupo,nombre);
                break;
            case 4:
                System.out.println("Saliendo...");
        }
    }while(opciones!=4);
    }

}
