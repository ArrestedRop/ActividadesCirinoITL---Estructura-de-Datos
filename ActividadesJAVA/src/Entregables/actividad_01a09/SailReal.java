package Entregables.actividad_01a09;

import Entregables.actividad_01a09.Extras.Misc;
import Entregables.actividad_01a09.Regis.RegistroArchivo;
import Entregables.actividad_01a09.Regis.RegistroManual;

import javax.swing.*;
import java.util.Scanner;
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
    public String goal() {
        String meta = "Programa para capturar y buscar datos de personas almacenadas en una colección,\n" +
                " usaremos captura de datos por centinela ademas de busqueda secuencial y binaria\n" +
                " en un arreglo de apuntadores a objetos\n";
        return meta;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        RegistroManual regisMan = new RegistroManual();
        RegistroArchivo regisArc = new RegistroArchivo();

        int opt;
        int cuenta = 0;
       Persona[] grupo = null;
        String menu = "\n--- MENU DE GESTIÓN (5.0 SAIL) ---\n" +
                "1. Registro Manual\n" +
                "2. Leer Archivo\n" +
                "3. Búsqueda Secuencial\n" +
                "4. Búsqueda Binaria (Requiere Orden)\n" +
                "5. Imprimir Lista\n" +
                "6. Salir\n" +
                "Selecciona una opción: ";

        do {
            try {
                String seleccion = JOptionPane.showInputDialog(null, menu,
                        "SAIL 5.0", JOptionPane.QUESTION_MESSAGE);
                opt = (seleccion == null) ? 6 : Integer.parseInt(seleccion);
            } catch (NumberFormatException e) { opt = 0; }

            switch (opt) {
                case 1 -> {
                    grupo = regisMan.data();
                    cuenta = regisMan.getCuenta();
                }
                case 2 -> {
                    String path = Misc.fileSearcher();
                    if (!path.isEmpty()) {
                        grupo = regisArc.data(path);
                        cuenta = regisArc.getCuenta();
                    }
                }
                case 3 -> {
                    String target = JOptionPane.showInputDialog("Nombre a buscar (Secuencial):");
                    int pos = searchSecuencial(target, grupo, cuenta);
                    imprimirIndividual(pos, target, grupo);
                }
                case 4 -> {
                    // Nota: Aquí deberías ordenar antes de llamar a la binaria paps
                    String target = JOptionPane.showInputDialog("Nombre a buscar (Binaria):");
                    int pos = searchBinaria(target, grupo, cuenta);
                    imprimirIndividual(pos, target, grupo);
                }
                case 5 -> imprimirLista(grupo, cuenta);
                case 6 -> System.out.println("Saliendo...");
            }
        } while (opt != 6);
    }

    // --- MÓDULOS FUSIONADOS (ESTILO SAIL) ---

    public static int searchSecuencial(String nombre, Persona[] grupo, int cuenta) {
        if (grupo == null) return -1;
        for (int i = 0; i < cuenta; i++) {
            if (nombre.equalsIgnoreCase(grupo[i].getNombre())) return i;
        }
        return -1;
    }

    public static int searchBinaria(String objetivo, Persona[] grupo, int cuenta) {
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

    public static void imprimirIndividual(int pos, String nombre, Persona[] grupo) {
        if (pos != -1) {
            Persona p = grupo[pos];
            String info = "Nombre: " + p.getNombre() + "\nNC: " + p.getNum_con() +
                    "\nFecha: " + p.getFecha_nac() + "\nPeso: " + p.getPeso() + "kg";
            JOptionPane.showMessageDialog(null, info, "Resultado",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró a: "
                    + nombre, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void imprimirLista(Persona[] grupo, int cuenta) {
        if (grupo == null || cuenta == 0) {
            JOptionPane.showMessageDialog(null, "Lista vacía");
            return;
        }
        StringBuilder sb = new StringBuilder("--- LISTA DE PERSONAS ---\n");
        for (int i = 0; i < cuenta; i++) {
            sb.append(i + 1).append(". ").append(grupo[i].getNombre()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

}