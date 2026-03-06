package Entregables.actividad_01a09;

import Entregables.actividad_01a09.Extras.Misc;
import Entregables.actividad_01a09.Regis.RegistroArchivo;
import Entregables.actividad_01a09.Regis.RegistroManual;
import Entregables.actividad_01a09.Extras.Terminal;

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

public class SailReal {

    public static void main(String[] args) {
       Terminal terminal = new Terminal("Terminal de impresion");
        RegistroManual regisMan = new RegistroManual();
        RegistroArchivo regisArc = new RegistroArchivo();
        SailReal prueba = new SailReal();

        terminal.imprimir(prueba.goal());

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
                        JOptionPane.showMessageDialog
                                (null, "Cantidad de datos cargados: " + cuenta,
                                        "Carga exitosa", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                case 3 -> {
                    String target = JOptionPane.showInputDialog("Nombre a buscar (Secuencial):");
                    int pos = prueba.searchSecuencial(target, grupo, cuenta);
                    prueba.imprimirIndividual(pos, target, grupo);
                }
                case 4 -> {
                    String target = JOptionPane.showInputDialog("Nombre a buscar (Binaria):");
                    int pos = prueba.searchBinaria(target, grupo, cuenta);
                    prueba.imprimirIndividual(pos, target, grupo);
                }
                case 5 -> prueba.imprimirLista(grupo, cuenta, terminal);
                case 6 -> System.out.println("Saliendo...");
            }
        } while (opt != 6);
    }

    public String goal() {
        String meta = "Programa para capturar y buscar datos de personas almacenadas en una colección,\n" +
                " usaremos captura de datos por centinela ademas de busqueda secuencial y binaria\n" +
                " en un arreglo de apuntadores a objetos\n";
        return meta;
    }

    public int searchSecuencial(String nombre, Persona[] grupo, int cuenta) {
        if (grupo == null) return -1;
        for (int i = 0; i < cuenta; i++) {
            if (nombre.equalsIgnoreCase(grupo[i].getNombre())) return i;
        }
        return -1;
    }

    public int searchBinaria(String objetivo, Persona[] grupo, int cuenta) {
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

    public void imprimirIndividual(int pos, String nombre, Persona[] grupo) {
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
                String Impresion = (i+1) + ".- | " + nom +
                        " | " + fecha_nac +
                        " | " + num_con +
                        " | " + peso +
                        " | " + talla;

                terminal.imprimir(Impresion);
            }
        }

    }
