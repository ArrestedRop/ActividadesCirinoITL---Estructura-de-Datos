/*
Tecnológico Nacional de México
Instituto Tecnológico de León
Ingeniería en Sistemas Computacionales
Estructuras de datos
Lunes y miercoles 7:00 a 8:45
viernes 7:00 a 7:50
Alumno: Villagomez Magaña Maximo Javier
Tarea 29
Fecha: 20/4/2026
*/

package Entregables.Actividad_29;

import java.io.*;

public class PruebaMezclaNatural {
    final int N = 716;
    final int TOPE = 999;

    // PROCESOS
    void mezclaNatural(File f) throws IOException {
        boolean ordenado = false;
        File f1 = new File("ArchivoAux1");
        File f2 = new File("ArchivoAux2");

        while (!ordenado) {
            int numSecuencias = distribute(f, f1, f2);
            if (numSecuencias <= 1) {
                ordenado = true;
            } else {
                mix(f1, f2, f);
            }
        }
    }

    // Distribuye secuencias naturales alternando entre f1 y f2
    int distribute(File f, File f1, File f2) throws IOException {
        DataInputStream flujo = new DataInputStream(new BufferedInputStream(new FileInputStream(f)));
        DataOutputStream flujo1 = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f1)));
        DataOutputStream flujo2 = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f2)));

        int numSecuencias = 0;
        int anterior, actual;
        boolean escribirEnF1 = true;

        try {
            anterior = flujo.readInt();
            numSecuencias = 1;
            flujo1.writeInt(anterior);

            while (true) {
                actual = flujo.readInt();

                if (actual < anterior) {
                    numSecuencias++;
                    escribirEnF1 = !escribirEnF1;
                }

                if (escribirEnF1) flujo1.writeInt(actual);
                else flujo2.writeInt(actual);

                anterior = actual;
            }
        } catch (EOFException e) {
        }

        flujo.close();
        flujo1.close();
        flujo2.close();
        return numSecuencias;
    }

    void mix(File f1, File f2, File f) throws IOException {
        DataOutputStream flujo = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
        DataInputStream flujo1 = new DataInputStream(new BufferedInputStream(new FileInputStream(f1)));
        DataInputStream flujo2 = new DataInputStream(new BufferedInputStream(new FileInputStream(f2)));

        int c1 = 0, c2 = 0;
        boolean hayC1 = false, hayC2 = false;

        try { c1 = flujo1.readInt(); hayC1 = true; } catch (EOFException e) {}
        try { c2 = flujo2.readInt(); hayC2 = true; } catch (EOFException e) {}

        while (hayC1 && hayC2) {
            boolean finTramo1 = false;
            boolean finTramo2 = false;

            while (!finTramo1 && !finTramo2) {
                if (c1 <= c2) {
                    flujo.writeInt(c1);
                    int ant = c1;
                    try {
                        c1 = flujo1.readInt();
                        if (c1 < ant) finTramo1 = true;
                    } catch (EOFException e) { hayC1 = false; finTramo1 = true; }
                } else {
                    flujo.writeInt(c2);
                    int ant = c2;
                    try {
                        c2 = flujo2.readInt();
                        if (c2 < ant) finTramo2 = true;
                    } catch (EOFException e) { hayC2 = false; finTramo2 = true; }
                }
            }

            while (!finTramo1) {
                flujo.writeInt(c1);
                int ant = c1;
                try {
                    c1 = flujo1.readInt();
                    if (c1 < ant) finTramo1 = true;
                } catch (EOFException e) { hayC1 = false; finTramo1 = true; }
            }
            while (!finTramo2) {
                flujo.writeInt(c2);
                int ant = c2;
                try {
                    c2 = flujo2.readInt();
                    if (c2 < ant) finTramo2 = true;
                } catch (EOFException e) { hayC2 = false; finTramo2 = true; }
            }
        }

        while (hayC1) { flujo.writeInt(c1); try { c1 = flujo1.readInt(); } catch (EOFException e) { hayC1 = false; } }
        while (hayC2) { flujo.writeInt(c2); try { c2 = flujo2.readInt(); } catch (EOFException e) { hayC2 = false; } }

        flujo.close();
        flujo1.close();
        flujo2.close();
    }

    void escribir(File f) {
        try (DataInputStream flujo = new DataInputStream(new BufferedInputStream(new FileInputStream(f)))) {
            int k = 0;
            System.out.println("--- ARCHIVO ORDENADO (MEZCLA NATURAL) ---");
            while (true) {
                System.out.print(flujo.readInt() + " ");
                if (++k % 11 == 0) System.out.println();
            }
        } catch (EOFException e) {
            System.out.println("\n*** Fin del archivo ***\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PruebaMezclaNatural p = new PruebaMezclaNatural();
        File f = new File("ArchivoOrigen");

        try {
            DataOutputStream flujo = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
            for (int j = 1; j <= p.N; j++)
                flujo.writeInt((int)(1 + p.TOPE * Math.random()));
            flujo.close();

            p.mezclaNatural(f);
            p.escribir(f);
        } catch (IOException e) {
            System.err.println("Error en la operación de archivos.");
        }
    }
}