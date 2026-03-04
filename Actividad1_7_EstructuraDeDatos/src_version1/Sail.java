import javax.swing.*;
/*
Tecnológico Nacional de México
Instituto Tecnológico de León
Ingeniería en Sistemas Computacionales
Estructuras de datos
Lunes y miercoles 7:00 a 8:45
viernes 7:00 a 7:50
Alumno: Villagomez Magaña Maximo Javier
Tarea 1-9
Fecha: 4/3/2026


*/

public class Sail {

    public static void main(String[] args) {

        //Se instancian cada una de las clases
        RegistroManual regisMan = new RegistroManual();
        RegistroArchivo regisArc = new RegistroArchivo();
        Busqueda buscador = new Busqueda();
        ImpresionIndividual imprimir = new ImpresionIndividual();
        ImpresionLista lista = new ImpresionLista();

        int opt;
        int cuenta = 0;
        Persona[] grupo = null;
        String menu = "\n--- MENU DE GESTIÓN (5.0 SAIL) ---\n\n" +
                "___________________________________________\n"+
                "1. Introducir datos de personas por teclado\n" +
                "2. Leer datos de un archivo de texto\n" +
                "3. Buscar alguna persona por nombre\n" +
                "4. Busqueda Binaria\n" +
                "5. Imprimir lista completa\n" +
                "6. Salir\n" +
                "___________________________________________\n\n"+
                "Selecciona una opcion: ";

        do{
            try {
             opt = Integer.parseInt(JOptionPane.showInputDialog(menu));
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
                    String nombre = JOptionPane.showInputDialog("Otorgue el nombre a buscar: ");
                    int pos = buscador.search(nombre, grupo, cuenta);
                    int compara  = buscador.getCompara();
                    imprimir.outs(pos, compara, grupo,nombre);
                }
                case 4 -> {
                    String nombre = JOptionPane.showInputDialog("Otorgue el nombre a buscar: ");

                }
                case 5 -> {
                    JOptionPane.showMessageDialog(null,"Impresion por medio de la lista");
                    lista.list(grupo);
                }
                case 6 -> System.out.println("Saliendo...");
            }
        }while(opt!=6);
    }
}
