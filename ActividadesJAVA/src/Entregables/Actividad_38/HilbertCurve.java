package Entregables.Actividad_38;

    /*
Tecnológico Nacional de México
Instituto Tecnológico de León
Ingeniería en Sistemas Computacionales
Estructuras de datos
Lunes y miercoles 7:00 a 8:45
viernes 7:00 a 7:50
Alumno: Villagomez Magaña Maximo Javier
Tarea 31
Fecha: 12/5/2026
*/

import java.util.Scanner;

    public class HilbertCurve {

        static int orden;
        static float distancia;
        static Scanner scanner = new Scanner(System.in);

        // 1. METAS
        public static void goal() {
            System.out.println("Script que dibuja la curva de Hilbert de manera recursiva (fractal)");
            System.out.println("utilizando graficas de tortuga relativas (avanzar y girar)\n");
        }

        // 2. DATOS
        public static void data() {
            System.out.print("Deme el nivel de profundidad (orden) de la curva fractal: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada invalida. Por favor ingrese un numero entero.");
                scanner.next();
            }
            orden = scanner.nextInt();

            System.out.print("Deme la longitud en pixeles para cada segmento: ");
            while (!scanner.hasNextFloat()) {
                System.out.println("Entrada invalida. Por favor ingrese un numero decimal o entero.");
                scanner.next();
            }
            distancia = scanner.nextFloat();
        }

        // 3. PROCESOS
        public static void drawHilbert(int nivel, int angulo) {
            if (nivel == 0) return;

            gira(angulo);
            drawHilbert(nivel - 1, -angulo);
            avanzar(distancia);

            gira(-angulo);
            drawHilbert(nivel - 1, angulo);
            avanzar(distancia);
            drawHilbert(nivel - 1, angulo);

            gira(-angulo);
            avanzar(distancia);
            drawHilbert(nivel - 1, -angulo);
            gira(angulo);
        }

        // 3.2 METODO avanzar
        public static void avanzar(float dist) {
            System.out.println("Avanzando " + dist + " unidades");
        }

        // 3.3 METODO gira
        public static void gira(int angulo) {
            System.out.println("Girando " + angulo + " grados");
        }

        // 4. SALIDA
        public static void canvas() {
            System.out.println("\nINICIALIZANDO LIENZO GRAFICO PARA CURVA DE HILBERT...");
            System.out.println("ORDEN | DISTANCIA");
            System.out.println("  " + orden + "   |   " + distancia + "\n");

            drawHilbert(orden, 90);
        }

        // 5. NAVEGACION
        public static void navigation() {
            goal();
            data();
            canvas();
            scanner.close();
        }

        public static void main(String[] args) {
            navigation();
        }
    }
