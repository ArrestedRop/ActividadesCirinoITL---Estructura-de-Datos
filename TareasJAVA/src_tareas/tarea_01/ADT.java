package tarea_01;
import java.util.Scanner;

import static tarea_01.Miscellaneus.arrayPrinter;

public class ADT {
    public static void main(String[] args) {
        ADT prueba = new ADT();
        int menu = 0;
        String menuMessage = "Opciones\n" +
                "1.- Variables de entrada|Salida" +
                "2.- ";
        int opt = 0;
        do {
            switch (opt) {
                case 1 -> {
                    prueba.systemOuts();
                }
                case 2 -> {
                    prueba.arrayCopy();
                }
                case 3 -> {

                }
            }
        }while(menu!=5);
    }

//        Metodos que nos permiten regresar informacion u obtener.
        void systemOuts () {
        Scanner scan = new Scanner(System.in);
            System.out.println("La clase systems nos permite" +
                    " imprimir mensajes o recabar informacion");
            System.out.println("Hola Mundo! - out");
            System.err.println("ALGO TRONO W - err");
            System.out.println("Introduzca su nombre - in");
            scan.nextLine();
        }

//        Metodo que nos permite copear el contenido de un arreglo a otrto arreglo
        void arrayCopy () {
        String[] arrayInicio = {"Carlos","Jose","Adolfo"};
        String[] arrayDestino = new String[3];
        System.arraycopy(arrayInicio,0,arrayDestino,0,3);
            System.out.println("Original");
        arrayPrinter(arrayInicio);
            System.out.println("Copia");
        arrayPrinter(arrayDestino);

        }
}
