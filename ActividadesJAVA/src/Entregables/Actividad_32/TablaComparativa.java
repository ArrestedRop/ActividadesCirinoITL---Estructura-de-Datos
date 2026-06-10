/*
Tecnológico Nacional de México
Instituto Tecnológico de León
Ingeniería en Sistemas Computacionales
Estructuras de datos
Lunes y miercoles 7:00 a 8:45
viernes 7:00 a 7:50
Alumno: Villagomez Magaña Maximo Javier
Tarea 32
Fecha: 12/5/2026
*/

package Entregables.Actividad_32;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Random;

public class TablaComparativa {
    long md, pd, prd, mn, pn, prn;
    String num;
    Scanner sc = new Scanner(System.in);

    // 1 META
    void goal() {
        String msg = "Script basico que permite medir el tiempo\n";
        msg += "en los escenarios mejor, peor y promedio de los \n";
        msg += "algoritmos de ordenamiento externo (Intercalacion Directa y Natural)\n";
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
    }

    void generador(int escenario, String nombreArchivo) {
        try {
            PrintWriter p = new PrintWriter(nombreArchivo);
            int cantidad = Integer.parseInt(num);
            Random r = new Random();

            for (int i = 0; i < cantidad; i++) {
                if (escenario == 1) p.println(i); // Mejor: Ya ordenado
                else if (escenario == 2) p.println(r.nextInt(cantidad * 10)); // Promedio: Aleatorio
                else p.println(cantidad - i); // Peor: Inverso
            }
            p.close();
        } catch (Exception e) {
            System.out.println("Error generando datos: " + e.getMessage());
        }
    }

    // 3 PROCESOS: INTERCALACIÓN DIRECTA
    void intercalacionDirecta(String fName) {
        int n = Integer.parseInt(num);
        int blockSize = 1;

        while (blockSize < n) {
            try {
                particionarDirecta(fName, "F1.txt", "F2.txt", blockSize);
                fusionarDirecta(fName, "F1.txt", "F2.txt", blockSize);
            } catch (Exception e) {}
            blockSize *= 2;
        }
    }

    void particionarDirecta(String fName, String f1Name, String f2Name, int blockSize) throws Exception {
        Scanner s = new Scanner(new File(fName));
        PrintWriter p1 = new PrintWriter(f1Name);
        PrintWriter p2 = new PrintWriter(f2Name);
        boolean toggle = true;

        while (s.hasNextInt()) {
            PrintWriter p = toggle ? p1 : p2;
            for (int i = 0; i < blockSize && s.hasNextInt(); i++)
                p.println(s.nextInt());
            toggle = !toggle;
        }
        s.close(); p1.close(); p2.close();
    }

    void fusionarDirecta(String fName, String f1Name, String f2Name, int blockSize) throws Exception {
        Scanner s1 = new Scanner(new File(f1Name));
        Scanner s2 = new Scanner(new File(f2Name));
        PrintWriter p = new PrintWriter(fName);
        int count1;
        int count2;

        boolean has1 = s1.hasNextInt();
        boolean has2 = s2.hasNextInt();
        int v1 = has1 ? s1.nextInt() : 0;
        int v2 = has2 ? s2.nextInt() : 0;

        while (has1 && has2) {
            count1 = 0;
            count2 = 0;

            while (count1 < blockSize && count2 < blockSize && has1 && has2) {
                if (v1 <= v2) {
                    p.println(v1);
                    has1 = s1.hasNextInt();
                    if (has1) v1 = s1.nextInt();
                    count1++;
                } else {
                    p.println(v2);
                    has2 = s2.hasNextInt();
                    if (has2) v2 = s2.nextInt();
                    count2++;
                }
            }
            while (count1 < blockSize && has1) {
                p.println(v1);
                has1 = s1.hasNextInt();
                if (has1) v1 = s1.nextInt();
                count1++;
            }
            while (count2 < blockSize && has2) {
                p.println(v2);
                has2 = s2.hasNextInt();
                if (has2) v2 = s2.nextInt();
                count2++;
            }
        }
        while (has1) {
            p.println(v1);
            has1 = s1.hasNextInt();
            if (has1) v1 = s1.nextInt();
        }
        while (has2) {
            p.println(v2);
            has2 = s2.hasNextInt();
            if (has2) v2 = s2.nextInt();
        }
        s1.close(); s2.close(); p.close();
    }

    // 3 PROCESOS: INTERCALACIÓN NATURAL
    void intercalacionNatural(String fName) {
        boolean ordenado = false;

        while (!ordenado) {
            try {
                ordenado = particionarNatural(fName, "F1.txt", "F2.txt");
                if (!ordenado) fusionarNatural(fName, "F1.txt", "F2.txt");
            } catch (Exception e) {}
        }
    }

    boolean particionarNatural(String fName, String f1Name, String f2Name) throws Exception {
        Scanner s = new Scanner(new File(fName));
        PrintWriter p1 = new PrintWriter(f1Name);
        PrintWriter p2 = new PrintWriter(f2Name);

        if (!s.hasNextInt()) {
            s.close(); p1.close(); p2.close();
            return true;
        }

        boolean toggle = true;
        int prev = s.nextInt();
        (toggle ? p1 : p2).println(prev);
        boolean soloUnaSecuencia = true;

        while (s.hasNextInt()) {
            int curr = s.nextInt();
            if (curr < prev) {
                toggle = !toggle;
                if (!toggle) soloUnaSecuencia = false;
            }
            (toggle ? p1 : p2).println(curr);
            prev = curr;
        }
        s.close(); p1.close(); p2.close();
        return soloUnaSecuencia;
    }

    void fusionarNatural(String fName, String f1Name, String f2Name) throws Exception {
        Scanner s1 = new Scanner(new File(f1Name));
        Scanner s2 = new Scanner(new File(f2Name));
        PrintWriter p = new PrintWriter(fName);
        boolean has1 = s1.hasNextInt();
        boolean has2 = s2.hasNextInt();
        int v1 = has1 ? s1.nextInt() : 0;
        int v2 = has2 ? s2.nextInt() : 0;

        while (has1 && has2) {
            boolean end1 = false;
            boolean end2 = false;

            while (!end1 && !end2) {
                if (v1 <= v2) {
                    p.println(v1);
                    if (s1.hasNextInt()) {
                        int next = s1.nextInt();
                        if (next < v1) end1 = true;
                        v1 = next;
                    } else { has1 = false; end1 = true; }
                } else {
                    p.println(v2);
                    if (s2.hasNextInt()) {
                        int next = s2.nextInt();
                        if (next < v2) end2 = true;
                        v2 = next;
                    } else { has2 = false; end2 = true; }
                }
            }
            while (!end1) {
                p.println(v1);
                if (s1.hasNextInt()) {
                    int next = s1.nextInt();
                    if (next < v1) end1 = true;
                    v1 = next;
                } else { has1 = false; end1 = true; }
            }
            while (!end2) {
                p.println(v2);
                if (s2.hasNextInt()) {
                    int next = s2.nextInt();
                    if (next < v2) end2 = true;
                    v2 = next;
                } else { has2 = false; end2 = true; }
            }
        }
        while (has1) {
            p.println(v1);
            has1 = s1.hasNextInt();
            if (has1) v1 = s1.nextInt();
        }
        while (has2) {
            p.println(v2);
            has2 = s2.hasNextInt();
            if (has2) v2 = s2.nextInt();
        }
        s1.close(); s2.close(); p.close();
    }

    // 4 SALIDA
    String formatoTiempo(long milisegundos) {
        long horas = milisegundos / 3_600_000L;
        long minutos = (milisegundos / 60_000L) % 60;
        long segundos = (milisegundos / 1_000L) % 60;
        long milis = milisegundos % 1000;

        return String.format("%02d:%02d:%02d.%03d", horas, minutos, segundos, milis);
    }

    long medirTiempoDirecta(int escenario) {
        String archivo = "datos_directa.txt";
        TimeElapsedMod crono = new TimeElapsedMod();

        generador(escenario, archivo);
        crono.inicio = System.currentTimeMillis();
        intercalacionDirecta(archivo); // Un solo recorrido basta
        crono.calcula();
        return crono.te;
    }

    long medirTiempoNatural(int escenario) {
        String archivo = "datos_natural.txt";
        TimeElapsedMod crono = new TimeElapsedMod();

        generador(escenario, archivo);
        crono.inicio = System.currentTimeMillis();
        intercalacionNatural(archivo); // Un solo recorrido basta
        crono.calcula();
        return crono.te;
    }

    void imprimirTabla() {
        System.out.println("\n--- TABLA COMPARATIVA DE TIEMPOS (ARCHIVOS) ---");
        System.out.printf("%-15s | %-20s | %-20s\n", "Escenario", "Mezcla Directa", "Mezcla Natural");
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-15s | %-20s | %-20s\n", "Mejor Caso", formatoTiempo(md), formatoTiempo(mn));
        System.out.printf("%-15s | %-20s | %-20s\n", "Promedio",   formatoTiempo(pd), formatoTiempo(pn));
        System.out.printf("%-15s | %-20s | %-20s\n", "Peor Caso",  formatoTiempo(prd), formatoTiempo(prn));
        System.out.println("Cantidad de datos en el archivo: " + num);
    }

    // 5 NAVEGACION
    public void run() {
        goal();
        data();

        System.out.println("Calentando motores de la JVM (Dry Run)...");
        String originalNum = num;
        num = "1000";
        medirTiempoDirecta(2);
        medirTiempoNatural(2);
        num = originalNum;
        // 1 = Mejor, 2 = Promedio, 3 = Peor
        System.out.println("Calculando tiempos oficiales (Esto puede tardar unos segundos dependiendo de los datos)...");
        md = medirTiempoDirecta(1);
        pd = medirTiempoDirecta(2);
        prd = medirTiempoDirecta(3);
        mn = medirTiempoNatural(1);
        pn = medirTiempoNatural(2);
        prn = medirTiempoNatural(3);
        imprimirTabla();

        new File("datos_directa.txt").delete();
        new File("datos_natural.txt").delete();
        new File("F1.txt").delete();
        new File("F2.txt").delete();
    }

    public static void main(String[] args) {
        TablaComparativa tc = new TablaComparativa();
        tc.run();
    }
}
