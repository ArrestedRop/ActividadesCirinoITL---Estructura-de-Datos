/*
Tecnológico Nacional de México
Instituto Tecnológico de León
Ingeniería en Sistemas Computacionales
Estructuras de datos
Lunes y miercoles 7:00 a 8:45
viernes 7:00 a 7:50
Alumno: Villagomez Magaña Maximo Javier
Tarea 27
Fecha: 20/4/2026
*/
package Entregables.actividad_27.core;

import Entregables.actividad_27.Utilities.*;
import java.io.File;

public class MergeSort {
    String path;
    String path1;
    File file;
    File file1;
    //META
    public void goal(Terminal terminal) {
        StringBuilder msg = new StringBuilder();

        msg.append("Programa que tiene como ");
        msg.append("finalidad probar el MergeSort");
        terminal.imprimir(String.valueOf(msg));
    }
    //DATOS
    public void data(Terminal terminal) {
        terminal.imprimir("Proporcione el primer archivo");
        path = IOManager.fileSearcher();
        terminal.imprimir("Proporcione el segundo archivo");
        path1 = IOManager.fileSearcher();
        file = new File(path);
        file1 = new File(path1);
    }
    //No hay procesos
    //RESULTADOS
    public void resultS(Terminal terminal) {
        Sorter.sort(file,file1,"resultado_ordenado.csv");
        terminal.imprimir("Archivo creado con exito");
    }

    public static void main(String[] args) {
        String msg = "Terminal de impresion";
        Terminal terminal = new Terminal(msg);
        MergeSort prueba = new MergeSort();

        prueba.goal(terminal);
        prueba.data(terminal);
        prueba.resultS(terminal);
    }

}
