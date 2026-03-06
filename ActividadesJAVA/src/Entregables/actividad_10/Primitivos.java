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
    String header = String.format("%-10s | %-10s | %-5s\n", "Tipo", "Mínimo", "Máximo");
    String format = "%-12s | %-10s | %-30s";

    String sByte = String.format(format, "byte", Byte.MIN_VALUE, Byte.MAX_VALUE);
    String sShort = String.format(format, "short", Short.MIN_VALUE, Short.MAX_VALUE);
    String sInt = String.format(format, "int", Integer.MIN_VALUE, Integer.MAX_VALUE);
    String sLong = String.format(format, "long", Long.MIN_VALUE, Long.MAX_VALUE);
    String sFloat = String.format("%-12s | %-30e | %-30e", "float", Float.MIN_VALUE, Float.MAX_VALUE);
    String sDouble = String.format("%-12s | %-30e | %-30e", "double", Double.MIN_VALUE, Double.MAX_VALUE);
    String sChar = String.format(format, "char", (int)Character.MIN_VALUE, (int)Character.MAX_VALUE);
    String sBool = String.format(format, "boolean", "false", "true");

    terminal.imprimir(bars);
    terminal.imprimir(header);
    terminal.imprimir(bars);
    terminal.multiPrint(sByte,sShort,sInt,sLong);
    terminal.multiPrint(sFloat,sDouble,sChar,sBool);
    }
}
