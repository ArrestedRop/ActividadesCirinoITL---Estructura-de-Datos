package Entregables.actividades15_19.actividad18;
import Entregables.actividades15_19.actividad17.Conjunto;

import javax.swing.*;

import static Entregables.actividades15_19.actividad18.misc.*;

public class prueba_Conjun {
    private Conjunto<?> set;
    private <?> element;

    void dataType(int op1) {
        switch(op1) {
            case 1 -> set = new Conjunto<Integer>();
            case 2 -> set = new Conjunto<String>();
            case 3 -> set = new Conjunto<Character>();
        }
    }

    void dataOpt(int op2) {
        switch (op2) {
            case 1 -> set.addElt();
        }
    }

    int menuType() {
        StringBuilder msg = new StringBuilder();
        msg.append("Proporcione el tipo de dato para su conjunto:\n ");
        msg.append("1.- Integer\n");
        msg.append("2.- String\n");
        msg.append("3.- Char\n");
        msg.append("4.-Salir");
        return menuCreator(msg.toString(), 3);
    }

    int menuOpt(){
        StringBuilder msg = new StringBuilder();
        msg.append("Proporcione la operacion a realizar:\n ");
        msg.append("1.- Agregar elemento\n");
        msg.append("2.- Eliminar elemento\n");
        msg.append("3.- Vaciar conjunto\n");
        msg.append("4.- Verificar si el conjunto contiene un elemento\n");
        msg.append("5.- Verificar si el conjunto tiene elementos\n");
        msg.append("6.- Verificar si el conjunto es subconjunto de otro\n");
        msg.append("7.- Unir conjuntos\n");
        msg.append("8.- Intersecar conjuntos\n");
        msg.append("9.- Diferencia de conjuntos\n");
        msg.append( "10.-Salir");
        return menuCreator(msg.toString(), 9);
    }

    int  menuCreator(String msg, int quantiy) {
        System.out.println(msg);
        String opcion;
        int op;
        do {
            do {
                opcion = JOptionPane.showInputDialog(msg);
            } while (!isInt(opcion));
            op = Integer.parseInt(opcion);
        } while (op != quantiy);
        return op;
    }

    public static void main(String[] args) {

        
    }
}