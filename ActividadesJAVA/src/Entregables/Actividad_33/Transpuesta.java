/*
Tecnológico Nacional de México
Instituto Tecnológico de León
Ingeniería en Sistemas Computacionales
Estructuras de datos
Lunes y miercoles 7:00 a 8:45
viernes 7:00 a 7:50
Alumno: Villagomez Magaña Maximo Javier
Tarea 33
Fecha: 6/5/2026
*/

package Entregables.Actividad_33;
/* Transpuesta.java
1.-Planteamiento: Para capturar datos en una matriz, trasponer y
                  mostrar tanto la matriz original como su transformada,
                  contabilizando las operaciones para comprobar un
                  desempeño de O(n^2).

2.-Entradas: escribir("Deme el # de filas de su matriz:"); fil = ?
             escribir("Deme el # de columnas:"); col = ?
             desde i = 0; mientras i < fil; incrementar i para
               desde j = 0; mientras j < col; incrementar j para
                 empezar
                    escribir: ("A ["+ i+", "+j+"]=");
                    A [i][j] = ?
                 terminar

3.-Cálculos: desde i=0; mientras i < fil; incrementar i
               desde j=0; mientras j < col; incrementar j para
                 T [i][j] = A[j][i]
                 intercambios++

4.-Salidas: para cada (M : Matriz)
              desde j=0; mientras j < col; incrementar j para empezar
                 desde i=0; mientras i < fil para
                    Escribir(M[j][i])
                 saltar renglon
              terminar
            Escribir analisis de complejidad O(n^2)

5.-Retroalimentación: Escribir("trasponer otra matriz? s/n:")
                      resp = ?
                      mientras (resp == 'S')
                         regresar al paso 2
                      de otro modo terminar

*/

import java.io.*;
import java.util.*;

class Transpuesta {
    Scanner teclado = new Scanner(System.in);
    int fil, col;
    long intercambios;
    double matriz[][];
    double transp[][];
    Miscelanius m = new Miscelanius();

    public void inicio() {
        String msg = "";

        msg += "\n\t Calcula LA TRANSPUESTA DE UNA MATRIZ Y COMPRUEBA O(n^2)";
        System.out.println(msg);
    }

    public double[][] entradas(double[][] otraCosa) {
        do fil = m.capInt("¿Cuantos renglones tiene su matriz?:");
        while (fil < 0);

        do col = m.capInt("¿Cuantas columnas hay en su matriz?:");
        while (col < 0);

        otraCosa = new double[fil][col];
        for (int i=0; i<fil; i++) {
            for (int j=0; j<col; j++)
                otraCosa[i][j] = m.capReal("Matriz[" + i + ", " + j + "]:");
        }
        return otraCosa;
    }

    // 3 PROCESOS
    public double[][] calculaTransp(int col, int fil) {
        transp = new double[col][fil];
        intercambios = 0;

        for (int i=0; i < fil; i++) {
            for (int j=0; j < col; j++) {
                transp[j][i] = matriz[i][j];
                intercambios++;
            }
        }
        return transp;
    }

    public void mostrar(double[][] mat) {
        for (int j=0; j < mat.length; j++) {
            for (int i=0; i < mat[j].length; i++)
                System.out.print(mat[j][i] + ", ");
            System.out.println();
        }
    }

    // 4 SALIDAS
    public void resultados() {
        String msg = "";

        System.out.println("\n--- MATRIZ ORIGINAL ---");
        mostrar(matriz);
        System.out.println("\n--- MATRIZ TRANSPUESTA ---");
        mostrar(transp);
        System.out.println("\n=== ANÁLISIS DE COMPLEJIDAD O(n^2) ===");
        System.out.println("Filas (n): " + fil);
        System.out.println("Columnas (m): " + col);

        System.out.println("Operaciones teóricas máximas (n * m): " + (fil * col));

        System.out.println("Intercambios reales realizados: " + intercambios);

        if (intercambios == (fil * col)) {
            msg += "Desempeño comprobado: O(n^2) - El algoritmo recorrió ";
            msg += "todos los elementos exitosamente.";
            System.out.println(msg);
        }
    }

    public static void main(String[] args) throws IOException {
        Transpuesta t = new Transpuesta();
        int resp = 'S';

        t.inicio();
        while (resp == 's' || resp == 'S') {
            t.matriz = t.entradas(t.matriz);
            t.transp = t.calculaTransp(t.col, t.fil);
            t.resultados();

            System.out.print("\n¿Quiere trasponer otra matriz? s/n: ");
            resp = System.in.read();
            System.in.skip(2);
        }
    }
}