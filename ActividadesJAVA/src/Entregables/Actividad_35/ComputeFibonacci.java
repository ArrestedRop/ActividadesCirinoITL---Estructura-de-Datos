/*
Tecnológico Nacional de México
Instituto Tecnológico de León
Ingeniería en Sistemas Computacionales
Estructuras de datos
Lunes y miercoles 7:00 a 8:45
viernes 7:00 a 7:50
Alumno: Villagomez Magaña Maximo Javier
Tarea 35
Fecha: 6/5/2026
*/

// Codigo extraido directamente del libro de Liang
// Liang Introduction to Java Programming
// en el capitulo 18 pagina 710

package Entregables.Actividad_35;

import java.util.Scanner;

public class ComputeFibonacci {
    /** Main method */
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an index for a Fibonacci number: ");
        int index = input.nextInt();

        // Find and display the Fibonacci number
        System.out.println("The Fibonacci number at index "
                + index + " is " + fib(index));

        input.close(); // Buena práctica para cerrar el recurso
    }

    /** The method for finding the Fibonacci number */
    public static long fib(long index) {
        if (index == 0) { // Base case
            return 0;
        } else if (index == 1) { // Base case
            return 1;
        } else { // Reduction and recursive calls
            return fib(index - 1) + fib(index - 2);
        }
    }
}
