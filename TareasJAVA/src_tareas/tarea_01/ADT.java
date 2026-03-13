/*
Tecnológico Nacional de México
Instituto Tecnológico de León
Ingeniería en Sistemas Computacionales
Estructuras de datos
Lunes y miercoles 7:00 a 8:45
viernes 7:00 a 7:50
Alumno: Villagomez Magaña Maximo Javier
Tarea 1
Fecha: 4/3/2026
*/
package tarea_01;

import javax.swing.JOptionPane;

public class ADT {

//  1.- meta
    String goal() {
        return "Programa para observar de manera" +
                " básica los diferentes métodos de la clase System";
    }
//  2.-Datos
    String dataFields() {
//      Metodo para Asignar los datos de los Fields
        String nombre = JOptionPane.showInputDialog("Introduzca su" +
                        "nombre (System.in):");
        return nombre;
    }
    String[] arrayCopyData() {
//        Metodo para asignar los datos a usar en el copyArray
        String[] arrayInicio = {"Carlos", "Jose", "Adolfo"};
        return arrayInicio;
    }
    String systemPropertyData() {
//      Metodo para definir los datos obtenidos por medio del systemPorperty
        String os = System.getProperty("os.name");
        return os;
    }

//  3.-Procesos
    void processFields() {
//      Clase para los procesos de los Fields
        String nombre = dataFields();
        if (!nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Nombre Valido (out), que tal todo, " + nombre +"?");
        } else {JOptionPane.showMessageDialog(null,
                    "Nombre Invalido (err)");}
    }

    String[] arrayCopyProcess(String [] arrayInicio) {
//      Procesos para el uso del metodo OutArrayCopy
        String[] arrayDestino = new String[3];
        System.arraycopy(arrayInicio, 0, arrayDestino, 0, 3);
        return arrayDestino;
    }
    void exitMethod() {
//      Metodo que pone en uso el System.exit
//      no cuenta con resultados ni data debido a que solo es un proceso
//      Estado de salida 0 = Terminación exitosa
        JOptionPane.showMessageDialog(null, "Cerrando el programa...");
        System.exit(0);
    }

//    4.-Resultados
    void outSystemFields() {
            processFields();
    }

    void outArrayCopy() {
        String[] arrayInicio = arrayCopyData();
        String[] arrayDestino = arrayCopyProcess(arrayInicio);
        String starter = String.join("\n-",arrayInicio);
        String finisher = String.join("\n+", arrayDestino);
        JOptionPane.showMessageDialog(null,
                "Arreglo original:\n" + "-"+starter);
        JOptionPane.showMessageDialog(null,
                "Arreglo final(OutArrayCopy):\n" + "+"+finisher);
    }

    void outSystemProperty() {
        String os = systemPropertyData();
        JOptionPane.showMessageDialog(null,
                "Tu Sistema Operativo es: " + os);

    }

//    5.- Navegabilidad
     void navigatation() {
        // Mostramos el objetivo una vez al inicio
        JOptionPane.showMessageDialog(null, goal());

        String menuMessage = "--- Menú de la Clase System ---\n" +
                "1. Entrada/Salida (err | out | in)\n" +
                "2. Copia de Arreglos (System.arraycopy)\n" +
                "3. Obtener Sistema Operativo (System.getProperty)\n" +
                "4. Salir del Programa\n\n" +
                "Ingrese su opción:";
        String entrada;
        int opt = 0;

        do {
            // Captura de opción mediante ventana
            entrada = JOptionPane.showInputDialog(menuMessage);
            // Manejo del botón Cancelar o cerrar la ventana
            if (entrada == null) break;
            try {
                opt = Integer.parseInt(entrada);
                switch (opt) {
                    case 1 -> outSystemFields();
                    case 2 -> outArrayCopy();
                    case 3 -> outSystemProperty();
                    case 4 -> exitMethod();
                    default -> JOptionPane.showMessageDialog(null,
                            "¡Opción no válida!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "introduzca un número válido");
            }
        } while (opt != 4);
    }

    public static void main(String[] args) {
        ADT prueba = new ADT();
        prueba.navigatation();
    }
}