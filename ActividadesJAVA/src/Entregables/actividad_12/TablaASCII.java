package Entregables.actividad_12;
import Entregables.actividad_12.Extras.Terminal;

public class TablaASCII {
    public static void main(String[] args) {
        Terminal terminal = new Terminal(
                "Impresion de la tabla ASCII - IBM PC 1981");

        TablaASCII prueba = new TablaASCII();
        terminal.imprimir(prueba.goal());
        prueba.outs(terminal);


        }

    public String goal() {
        String meta = "Programa que imprime en una terminal" +
                " la tabla de caracteres ASCII de la IBM PC 1981";
        return meta;
    }

    public void outs(Terminal terminal) {
            //Definimos el caracter y un StringBuilder(Pa que se vea mas bonis)
            char character;
            StringBuilder linea = new StringBuilder();

            //Creamos una terminal ( no es necesaria, solo es pa que se vea mas lampara)

            String titulo = "\n\n  Lista de caracteres ASCII - IBM PC 1981" +
                    "\n  ________________________________\n";
            terminal.imprimir(titulo);

            //Ciclo que nos ayuda a imprimir el StringBuilder con la info de los characters
            for(int i = 0;i <=256; i++) {
                character = (char) i;
                //Formato que permite la existencia de "Columnas"
                linea.append(String.format("%4d: %c\t",i,character));
                //Impresion
                if(i%5 == 4) {
                    terminal.imprimir(linea.toString());
                    linea.setLength(0);
                }
            }
            //Impreison por si quedan cosas dentro del StringBuilder sin imprimir
            if(linea.length()> 0)
                terminal.imprimir(linea.toString());
    }
}
