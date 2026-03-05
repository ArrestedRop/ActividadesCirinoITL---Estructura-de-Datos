package Entregables.actividad_12;
import Entregables.actividad_12.Extras.Terminal;

public class TablaASCII {
    public static void main(String[] args) {
        char character;
        Terminal terminal = new Terminal(
                "\n\nImpresion de la tabla ASCII - IBM PC 1981");
        String titulo = "Lista de caracteres ASCII - IBM PC 1981" +
                "\n________________________________\n";
        terminal.imprimir(titulo);


        for(int i = 0;i <=256; i++) {
            character = (char) i;
            terminal.imprimir((i) + ".-" + character);
        }
    }
}
