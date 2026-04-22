package Entregables.actividad_26.core;

import Entregables.actividad_26.Utilities.IOManager;
import Entregables.actividad_26.Utilities.Terminal;
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
