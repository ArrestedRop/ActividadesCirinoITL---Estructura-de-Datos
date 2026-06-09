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

package Entregables.Actividad_31;
import java.util.Scanner;

public class TablaComparativa {
    long MS, PS, PRS, MB, PB, PRB;
    int[] Arreglo;
    String num;
    Scanner sc = new Scanner(System.in);


    // 1 META
    void goal() {
        String msg = "Script basico que permite medir el tiempo\n";
        msg += "en cada uno de los escenarios de los \n";
        msg += "algoritmos de busqueda secuencial y binaria\n";
        System.out.println(msg);
    }

    // 2 DATOS
    void data() {
        System.out.print("Deme la cantidad de terminos que desea generar: ");
        num = sc.nextLine();

        while(!Misc.isInt(num)) {
            System.out.print("Dato erroneo, proporcione el dato de nuevo: ");
            num = sc.nextLine();
        }
        Arreglo = new int[Integer.parseInt(num)];
    }

    void generador() {
        // Llenamos el arreglo con números en orden para que la búsqueda binaria funcione
        for(int i = 0; i < Arreglo.length; i++) {
            Arreglo[i] = i;
        }
    }

    // 3 PROCESOS
    int searchSecuencial(int[] Arreglo, int busq) {
        for(int i = 0; i < Arreglo.length; i++) {
            if (Arreglo[i] == busq) return i;
        }
        return -1;
    }

    int searchBinaria(int[] Arreglo, int busq) {
        int inicio = 0;
        int fin = Arreglo.length - 1;

        while (inicio <= fin) {
            int mitad = inicio + (fin - inicio) / 2;

            if (Arreglo[mitad] == busq) return mitad;
            if (Arreglo[mitad] < busq) inicio = mitad + 1;
            else fin = mitad - 1;
        }
        return -1;
    }

    // 4 SALIDA (Cálculos de tiempo y formato)
    String formatoTiempo(long milisegundos) {
        long horas = milisegundos / 3_600_000L;
        long minutos = (milisegundos / 60_000L) % 60;
        long segundos = (milisegundos / 1_000L) % 60;
        long milis = milisegundos % 1000;

        return String.format("%02d:%02d:%02d.%03d", horas, minutos, segundos, milis);
    }

    long TElapserS(int[] Arreglo, int val) {
        TimeElapsedMod crono = new TimeElapsedMod();
        crono.inicio = System.currentTimeMillis(); // Reseteamos justo antes de buscar
        searchSecuencial(Arreglo, val);
        crono.calcula();
        return crono.te;
    }

    long TElapserB(int[] Arreglo, int val) {
        TimeElapsedMod crono = new TimeElapsedMod();
        crono.inicio = System.currentTimeMillis(); // Reseteamos justo antes de buscar
        searchBinaria(Arreglo, val);
        crono.calcula();
        return crono.te;
    }

    void imprimirTabla() {
        System.out.println("\n--- TABLA COMPARATIVA DE TIEMPOS ---");
        System.out.printf("%-15s | %-15s | %-15s\n", "Escenario", "Secuencial", "Binaria");
        System.out.println("---------------------------------------------------");

        System.out.printf("%-15s | %-15s | %-15s\n", "Mejor Caso", formatoTiempo(MS), formatoTiempo(MB));
        System.out.printf("%-15s | %-15s | %-15s\n", "Promedio",   formatoTiempo(PS), formatoTiempo(PB));
        System.out.printf("%-15s | %-15s | %-15s\n", "Peor Caso",  formatoTiempo(PRS), formatoTiempo(PRB));
        System.out.println("Cantidad de datos usados: " + num);
    }


    // 5 NAVEGACION

    public void run() {
        goal();
        data();
        generador();

        int n = Arreglo.length;


        int mejorCaso = Arreglo[0]; // Primer elemento (mejor para secuencial)
        int casoPromedio = Arreglo[n / 2]; // Elemento a la mitad (mejor para binaria)
        int peorCaso = Arreglo[n - 1]; // Último elemento


        MS = TElapserS(Arreglo, mejorCaso);
        PS = TElapserS(Arreglo, casoPromedio);
        PRS = TElapserS(Arreglo, peorCaso);

        MB = TElapserB(Arreglo, casoPromedio); // Da a la primera
        PB = TElapserB(Arreglo, Arreglo[n / 4]); // Requiere iterar un poco
        PRB = TElapserB(Arreglo, peorCaso); // Se va a un extremo

        imprimirTabla();
    }

    public static void main(String[] args) {
        TablaComparativa tc = new TablaComparativa();
        tc.run();
    }
}
