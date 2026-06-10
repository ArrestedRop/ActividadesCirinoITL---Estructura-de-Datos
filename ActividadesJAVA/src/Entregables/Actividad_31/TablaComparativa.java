/*
Tecnológico Nacional de México
Instituto Tecnológico de León
Ingeniería en Sistemas Computacionales
Estructuras de datos
Lunes y miercoles 7:00 a 8:45
viernes 7:00 a 7:50
Alumno: Villagomez Magaña Maximo Javier
Tarea 31
Fecha: 5/6/2026
*/

//10000000

package Entregables.Actividad_31;
import java.util.Scanner;

public class TablaComparativa {
    long ms, ps, prs, mb, pb, prb;
    int[] arreglo;
    String num;
    Scanner sc = new Scanner(System.in);

    // 1 META
    void goal() {
        String msg = "Script basico que permite medir el tiempo\n";

        msg += "en los escenarios mejor, peor y promedio de los \n";
        msg += "algoritmos de busqueda secuencial y binaria\n";
        System.out.println(msg);
    }

    // 2 DATOS
    void data() {
        System.out.print("Deme la cantidad de terminos que desea generar: ");
        num = sc.nextLine();
        while(!Misc.isInt(num) || Integer.parseInt(num) <= 0) {
            System.out.print("Dato erroneo, proporcione el dato de nuevo: ");
            num = sc.nextLine();
        }
        arreglo = new int[Integer.parseInt(num)];
    }

    void generador() {
        for(int i = 0; i < arreglo.length; i++) arreglo[i] = i;
    }

    // 3 PROCESOS
    int searchSecuencial(int[] arr, int busq) {
        for(int i = 0; i < arr.length; i++) if (arr[i] == busq) return i;
        return -1;
    }

    int searchBinaria(int[] arr, int busq) {
        int inicio = 0;
        int fin = arr.length - 1;
        int mitad;

        while (inicio <= fin) {
            mitad = inicio + (fin - inicio) / 2;
            if (arr[mitad] == busq) return mitad;
            if (arr[mitad] < busq) inicio = mitad + 1;
            else fin = mitad - 1;
        }
        return -1;
    }

    // 4 SALIDA
    String formatoTiempo(long milisegundos) {
        long horas = milisegundos / 3_600_000L;
        long minutos = (milisegundos / 60_000L) % 60;
        long segundos = (milisegundos / 1_000L) % 60;
        long milis = milisegundos % 1000;

        return String.format("%02d:%02d:%02d.%03d", horas, minutos, segundos, milis);
    }

    long medirTiempoSecuencial(int[] arr, int val) {
        TimeElapsedMod crono = new TimeElapsedMod();

        crono.inicio = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++) {searchSecuencial(arr, val);}
        crono.calcula();
        return crono.te;
    }

    long medirTiempoBinaria(int[] arr, int val) {
        TimeElapsedMod crono = new TimeElapsedMod();

        crono.inicio = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++) {searchBinaria(arr, val);}
        crono.calcula();
        return crono.te;
    }

    void imprimirTabla() {
        System.out.println("\n--- TABLA COMPARATIVA DE TIEMPOS ---");
        System.out.printf("%-15s | %-15s | %-15s\n", "Escenario", "Secuencial", "Binaria");
        System.out.println("---------------------------------------------------");
        System.out.printf("%-15s | %-15s | %-15s\n", "Mejor Caso", formatoTiempo(ms), formatoTiempo(mb));
        System.out.printf("%-15s | %-15s | %-15s\n", "Promedio",   formatoTiempo(ps), formatoTiempo(pb));
        System.out.printf("%-15s | %-15s | %-15s\n", "Peor Caso",  formatoTiempo(prs), formatoTiempo(prb));
        System.out.println("Cantidad de datos procesados: " + (10000L * Integer.parseInt(num)));
    }

    // 5 NAVEGACION
    public void run() {
        int n;
        int mejorCaso;
        int casoPromedio;
        int peorCaso;

        goal();
        data();
        generador();
        n = arreglo.length;
        mejorCaso = arreglo[0];
        casoPromedio = arreglo[n / 2];
        peorCaso = arreglo[n - 1];
        System.out.println("Encendiendo la JVM...");
        medirTiempoSecuencial(arreglo, casoPromedio);
        medirTiempoBinaria(arreglo, casoPromedio);
        ms = medirTiempoSecuencial(arreglo, mejorCaso);
        ps = medirTiempoSecuencial(arreglo, casoPromedio);
        prs = medirTiempoSecuencial(arreglo, peorCaso);
        mb = medirTiempoBinaria(arreglo, casoPromedio);
        pb = medirTiempoBinaria(arreglo, arreglo[n / 4]);
        prb = medirTiempoBinaria(arreglo, peorCaso);
        imprimirTabla();
    }

    public static void main(String[] args) {
        TablaComparativa tc = new TablaComparativa();
        tc.run();
    }
}