package Entregables.actividad_10;
/*
Tecnológico Nacional de México
Instituto Tecnológico de León
Ingeniería en Sistemas Computacionales
Estructuras de datos
Lunes y miercoles 7:00 a 8:45
viernes 7:00 a 7:50
Alumno: Villagomez Magaña Maximo Javier
Tarea 10
Fecha: 6/3/2026
*/
import Entregables.actividad_10.Extras.Terminal;
public class Primitivos {
    public static void main(String[] args) {
        Terminal terminal = new Terminal("Terminal de impresion");
        Primitivos prueba = new Primitivos();

        prueba.goal(terminal);
        prueba.results(terminal);
    }

    public void goal(Terminal terminal) {
        String meta = "Programa para imprimir los" +
                " limites de los tipos de datos primitivos en java\n\n";
        terminal.imprimir(meta);
    }

    public void results(Terminal terminal) {

        String bars = "____________________________________________________________\n";


        String sByte = "byte: " + Byte.MIN_VALUE;
        String sShort ="short: " + Short.MIN_VALUE;
        String sInt = "int: " + Integer.MIN_VALUE;
        String sLong = "long: " + Long.MIN_VALUE;
        String sFloat = "float: "+ Float.MIN_VALUE;
        String sDouble ="double: " + Double.MIN_VALUE;
        String sChar = "char: " + (int)Character.MIN_VALUE;
        String sBool =  "false";
        terminal.imprimir("Minimo");
        terminal.imprimir(bars);
        terminal.multiPrint(sByte,sShort,sInt,sLong);
        terminal.multiPrint(sFloat,sDouble,sChar,sBool);
        terminal.imprimir(bars);
        sByte = "byte: " + Byte.MAX_VALUE;
        sShort ="short: " + Short.MAX_VALUE;
        sInt = "int: " + Integer.MAX_VALUE;
        sLong = "long: " + Long.MAX_VALUE;
        sFloat = "float: "+ Float.MAX_VALUE;
        sDouble ="double: " + Double.MAX_VALUE;
        sChar = "char: " + (int)Character.MAX_VALUE;
        sBool =  "True";
        terminal.imprimir("Maximo");
        terminal.imprimir(bars);
        terminal.multiPrint(sByte,sShort,sInt,sLong);
        terminal.multiPrint(sFloat,sDouble,sChar,sBool);
        terminal.imprimir(bars);

    }
}
