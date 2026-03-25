package Entregables.actividad_01a09;

import Entregables.actividad_01a09.Extras.Misc;
import Entregables.actividad_01a09.Regis.RegistroArchivo;
import Entregables.actividad_01a09.Regis.RegistroManual;
import Entregables.actividad_01a09.Extras.Terminal;

import javax.swing.*;
import java.io.FileNotFoundException;

import static Entregables.actividad_01a09.Extras.Misc.isInt;

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

public class SailReal {
    private Persona[] grupo;
    private double time;
    private int cuenta, pos;
    private String target;
    private Terminal terminal = new Terminal("TERMINAL DEL EJERCICIO 9");
    static JOptionPane JOp = new JOptionPane();

    public void goal(Terminal terminal) {// 1.- Meta
        String meta = "Programa para capturar y buscar datos de personas almacenadas en una colección,\n";
        meta += " usaremos captura de datos por centinela ademas de busqueda secuencial y binaria\n";
        meta += " en un arreglo de apuntadores a objetos\n";
        terminal.imprimir(meta);
    }
    // 2.- Data
    // La data se registra en las clases RegistroArchivo y RegistroManual.
    // Ambos se encuentran en la carpeta Regis
    void data(int selection) throws FileNotFoundException {
        RegistroManual manReg = new RegistroManual();
        RegistroArchivo arcReg = new RegistroArchivo();

        switch(selection) {
            case 1 -> {
                grupo = manReg.data();
                cuenta = manReg.getCuenta();
            }
            case 2 -> {
                String path = Misc.fileSearcher();
                if (!path.isEmpty()) {
                    grupo = arcReg.data(path);
                    cuenta = arcReg.getCuenta();
                    String quantity = "Cantidad de datos cargados: ";
                    JOp.showMessageDialog(null, quantity + cuenta, "Carga exitosa", JOp.INFORMATION_MESSAGE);
                }
            }
        }
    }
    // 3.- Procesos
    int searchSecuencial(String nombre, Persona[] grupo, int cuenta) {
        if (grupo == null) return -1;
        for (int i = 0; i < cuenta; i++)
            if (nombre.equalsIgnoreCase(grupo[i].getNombre())) return i;
        return -1;
    }

    int searchBinaria(String objetivo, Persona[] grupo, int cuenta) {
        if (grupo == null) return -1;
        int inicio = 0, fin = cuenta - 1;
        while (inicio <= fin) {
            int mitad = inicio + (fin - inicio) / 2;
            int res = objetivo.compareToIgnoreCase(grupo[mitad].getNombre());
            if (res == 0) return mitad;
            if (res > 0) inicio = mitad + 1;
            else fin = mitad - 1;
        }
        return -1;
    }

    void posnTarg(int selection) {
        target = JOp.showInputDialog("Nombre a buscar:");
        if (selection == 3) pos = searchSecuencial(target, grupo, cuenta);
        else pos = searchBinaria(target, grupo, cuenta);
    }

    void procesess(int selection) {
        switch(selection) {
            case 3, 4 -> posnTarg(selection);
        }
    }

    void outs(int selection) throws FileNotFoundException {
        switch(selection) {
            case 3, 4 -> imprimirIndividual(pos, target, grupo);
            case 5 -> imprimirLista(grupo, cuenta, terminal);
            case 6 -> JOp.showMessageDialog(null, "Saliendo...");
            }
        }

    public void imprimirIndividual(int pos, String nombre, Persona[] grupo) {
        if (pos != -1) {
            Persona p = grupo[pos];
            String info = "Nombre: " + p.getNombre() + "\nNC: " + p.getNum_con();
            info +="\nFecha: " + p.getFecha_nac() + "\nPeso: " + p.getPeso() + "kg";

            JOp.showMessageDialog(null, info, "Resultado",JOp.INFORMATION_MESSAGE);
        } else
            JOp.showMessageDialog(null, "No se encontró a: "+ nombre, "Error", JOp.ERROR_MESSAGE);
    }

    public void imprimirLista(Persona[] grupo, int cuenta,Terminal terminal) {
        if (grupo == null || cuenta == 0) {
            JOptionPane.showMessageDialog(null, "Lista vacía");
            return;
        }
            for(int i = 0; i < cuenta; i++){
                String nom = grupo[i].getNombre();
                String fecha_nac = grupo[i].getFecha_nac();
                String num_con = grupo[i].getNum_con();
                double peso = grupo[i].getPeso();
                double talla = grupo[i].getTalla();
                String impresion = (i+1) + ".- | " + nom;
                impresion += " | " + fecha_nac ;
                impresion += " | " + num_con;
                impresion += " | " + peso;
                impresion += " | " + talla;

                terminal.imprimir(impresion);
            }
        }

    // 5.- Navegabilidad
    public int menu() {
        String opt;
        int option;
        String menu = "\n--- MENU DE GESTIÓN (5.0 SAIL) ---\n" +
                "1. Registro Manual\n" +
                "2. Leer Archivo\n" +
                "3. Búsqueda Secuencial\n" +
                "4. Búsqueda Binaria (Requiere Orden)\n" +
                "5. Imprimir Lista\n" +
                "6. Salir\n" +
                "Selecciona una opción: ";
        do {
            do opt = JOp.showInputDialog(null, menu, "Menu de opciones");
            while (!isInt(opt));
            option = Integer.parseInt(opt);
        }  while (option < 1 || option > 6);
            return option;
    }

    // MAIN
    public static void main(String[] args) throws FileNotFoundException {
       Terminal terminal = new Terminal("Terminal de impresion");
        SailReal prueba = new SailReal();
        prueba.goal(terminal);

        int selection;
        do {
            selection = prueba.menu();
        prueba.data(selection);
        prueba.procesess(selection);
        prueba.outs(selection);
        }while(selection != 6);
    }
}