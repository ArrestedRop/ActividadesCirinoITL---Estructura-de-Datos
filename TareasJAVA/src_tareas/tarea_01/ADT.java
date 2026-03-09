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
import static tarea_01.Miscellaneus.arrayPrinter;

public class ADT {
    public static void main(String[] args) {
        ADT prueba = new ADT();

        // Mostramos el objetivo una vez al inicio
        JOptionPane.showMessageDialog(null, prueba.goal());

        String menuMessage = "--- Menú de la Clase System (ADT) ---\n" +
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
                opt = Integer.parseInt(entrada); // Convertimos texto a número
                switch (opt) {
                    case 1 -> prueba.systemOuts();
                    case 2 -> prueba.arrayCopy();
                    case 3 -> prueba.systemProperty();
                    case 4 -> prueba.exitMethod();
                    default -> JOptionPane.showMessageDialog(null,
                            "¡Opción no válida!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "introduzca un número válido");
            }

        } while (opt != 4); // El bucle sigue hasta elegir Salir
    }

    String goal() {
        return "Programa para observar de manera" +
                " básica los diferentes métodos de la clase System";
    }

    void systemOuts() {
        String nombre = JOptionPane.showInputDialog("Introduzca su nombre (System.in):");
        System.out.println("¡Hola Mundo! - Salida Estándar (out)");
        System.err.println("¡ALGO TRONÓ W! - Salida de Error (err)");
        JOptionPane.showMessageDialog(null, "Hola " + nombre +
                "Revisa la consola para ver los flujos out/err.");
    }

    void arrayCopy() {
        String[] arrayInicio = {"Carlos", "Jose", "Adolfo"};
        String[] arrayDestino = new String[3];
        // Copia directa de bloques de memoria
        System.arraycopy(arrayInicio, 0, arrayDestino, 0, 3);

        System.out.println("Original:");
        arrayPrinter(arrayInicio);
        System.out.println("Copia:");
        arrayPrinter(arrayDestino);

        JOptionPane.showMessageDialog(null, "Arreglos copiados, Revisa la consola para ver los resultados.");
    }

    void systemProperty() {
        // Capturamos la propiedad y la mostramos en el diálogo
        String os = System.getProperty("os.name");
        JOptionPane.showMessageDialog(null, "Tu Sistema Operativo es: " + os);
    }

    void exitMethod() {
        // Estado de salida 0 = Terminación exitosa
        JOptionPane.showMessageDialog(null, "Cerrando el programa...");
        System.exit(0);
    }
}