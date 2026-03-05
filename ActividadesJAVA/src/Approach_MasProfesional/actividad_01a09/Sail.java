package Approach_MasProfesional.actividad_01a09;

import Approach_MasProfesional.actividad_01a09.Extras.Misc;
import Approach_MasProfesional.actividad_01a09.Extras.Terminal;
import Approach_MasProfesional.actividad_01a09.Printers.ImpresionIndividual;
import Approach_MasProfesional.actividad_01a09.Printers.ImpresionLista;
import Approach_MasProfesional.actividad_01a09.Regis.RegistroArchivo;
import Approach_MasProfesional.actividad_01a09.Regis.RegistroManual;
import Approach_MasProfesional.actividad_01a09.Searchers.Busqueda;
import Approach_MasProfesional.actividad_01a09.Searchers.BusquedaBinaria;
import Entregables.actividad_01a09.Persona;

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
        Sail main = new Sail();
        RegistroManual regisMan = new RegistroManual();
        RegistroArchivo regisArc = new RegistroArchivo();
        Busqueda buscador = new Busqueda();
        ImpresionIndividual imprimir = new ImpresionIndividual();
        ImpresionLista lista = new ImpresionLista();
        BusquedaBinaria binaria = new BusquedaBinaria();
        Terminal terminal = new Terminal("Approach_MasProfesional.tarea_01.Extras.Terminal de impresion");

        boolean arrayRegistrado = false;
        int opt;
        int cuenta = 0;

        terminal.imprimir(main.goal());

        Persona[] grupo = null;
        String menu = "\n--- MENU DE GESTIÓN (5.0 SAIL) ---\n\n" +
                "___________________________________________\n"+
                "1. Introducir datos de personas por teclado\n" +
                "2. Leer datos de un archivo de texto\n" +
                "3. Buscar alguna persona por nombre\n" +
                "4. Approach_MasProfesional.tarea_01.Searchers.Busqueda Binaria\n" +
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
                    arrayRegistrado = true;
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
                    arrayRegistrado = true;
                }
                case 3 -> {
                    if (arrayRegistrado == true) {
                        String nombre = JOptionPane.showInputDialog("Otorgue el nombre a buscar: ");
                        int pos = buscador.search(nombre, grupo, cuenta);
                        int compara = buscador.getCompara();
                        imprimir.outs(pos, compara, grupo, nombre);
                    }
                    else
                        JOptionPane.showMessageDialog(null,
                                "Ningun dato fue registrado",
                                "ERRPR",JOptionPane.ERROR_MESSAGE);
                }
                case 4 -> {
                    if (arrayRegistrado == true) {
                        String nombre = JOptionPane.showInputDialog("Otorgue el nombre a buscar: ");
                        int pos = binaria.binarySearch(nombre,grupo,cuenta);
                        int compara = binaria.getCompara();
                        imprimir.outs(pos,compara,grupo,nombre);
                    }

                }
                case 5 -> {
                    JOptionPane.showMessageDialog(null,"Impresion por medio de la lista");
                    lista.list(grupo,terminal);
                }
                case 6 -> System.out.println("Saliendo...");
            }
        }while(opt!=6);
    }

    public String goal() {
        String meta = "Programa para capturar y buscar datos de personas almacenadas en una colección,\n" +
                " usaremos captura de datos por centinela ademas de busqueda secuencial y binaria\n" +
                " en un arreglo de apuntadores a objetos\n";
        return meta;
    }
}

