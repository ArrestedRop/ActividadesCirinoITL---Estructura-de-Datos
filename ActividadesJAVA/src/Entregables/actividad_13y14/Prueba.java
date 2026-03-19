/*
Tecnológico Nacional de México
Instituto Tecnológico de León
Ingeniería en Sistemas Computacionales
Estructuras de datos
Lunes y miercoles 7:00 a 8:45
viernes 7:00 a 7:50
Alumno: Villagomez Magaña Maximo Javier
Tarea 14
Fecha: 4/3/2026
*/

package Entregables.actividad_13y14;
import javax.swing.*;
import static Entregables.actividad_13y14.Misc.*;

public class Prueba {
    JOptionPane JOp = new JOptionPane();
    Rational r1, r2, r3;
    int i, exp, opA, opC;
    boolean operatorflag;

    public void goal() {    //    1.- Meta
        String msg = "Programa que busca poner a prueba cada una de";

        msg += " las capacidades dentro del Abstract Data Type Rational";
        JOp.showMessageDialog(null,msg);
    }

    void aritmetica() {
        String msg = "1.- Aritmetica de quebrados\n";

        msg += "2.-Aritmetica de quebrados y enteros\n"
        msg += "3.- No hacer nada"
        opA = menu(msg,1,3);
        capturar2(opA);
    }

    void compara() {
        String msg = "1.- Igual\n2.- Mayor que\n3.- Menor que\n";

        msg += "4.- Mayor igual\n5.- Menor igual\n6.- No igual";
        opC = menu(msg, 1, 6);
        r1 = capturarRat();
        r2 = capturarRat();
    }

    public void data(int selection) { //    2.- Data
        switch(selection) {
            case 1,2,3,4 -> aritmetica();
            case 5 -> { 
                         r1 = capturarRat();
                         exp = capturarInt("exponente");  
                      }
            case 6,7 -> r1 = capturarRat();
            case 8 -> compara();
        }
    }

//    Capturadores de INT y RATIONALs
    public static int capturarInt(String prompt) {
        String ent;
        do {
            ent = JOp.showInputDialog(null,
                    "Proporcione el " + prompt, "Capturador de Operadores");
        }while(!isInt(ent));
        return Integer.parseInt(ent);
    }

    public static Rational capturarRat() {
        String title = "Capturador de Operadores";
        String x;
        String y;

        do x = JOp.showInputDialog(null,"Proporcione el numerador", title);
        while (!isInt(x));
        do y = JOp.showInputDialog(null,"Proporcione el denominador", title);
        while(!isInt(y));
        return new Rational(Integer.parseInt(x),Integer.parseInt(y));
    }

    public void capturar2(int op) {
        if (op == 1) {
            r1 = capturarRat();
            r2 = capturarRat();
        }
        else {
            r1 = capturarRat();
            i = capturarInt("Numero Entero");
        }
    }

    //    3.- Procesos

    public void processes(int selection) {
        if (selection < 8) {
            this.r3 = switch(selection) {
                case 1, 2,
                     3, 4 -> (opA == 1) ? aritmethics(selection, r1, r2)
                                        : mixture(selection, r1,i);
                case 5 -> r1.exponentiation(r1,exp);
                case 6 -> r1.negation(r1);
                case 7 -> r1.assignment(capturarRat());
                default -> null;
                };
            }
        else operatorflag = ratOperators(opC,r1,r2);
    }

//    Comparacion de rationals
    public static boolean ratOperators(int op,Rational r1, Rational r2) {
        return switch (op) {
            case 1 -> r1.equalsOperator(r1,r2);
            case 2 -> r1.greater_thanOperator(r1,r2);
            case 3 -> r1.less_thanOperator(r1,r2);
            case 4 -> r1.greater_equalsOperator(r1,r2);
            case 5-> r1.less_equalsOperator(r1,r2);
            case 6 -> r1.notEquals_Operator(r1,r2);
            default -> false;
        };
    }

//    Procesos matematicos
    public static Rational aritmethics(int op,Rational r1, Rational r2) {
        return switch(op) {
            case 1 -> r1.addition(r1,r2);
            case 2 -> r1.subtraction(r1,r2);
            case 3 -> r1.multiplication(r1,r2);
            case 4 -> r1.division(r1,r2);
            default -> null;
        };
    }

    public static Rational mixture(int op, Rational r1, int i) {
        return switch(op) {
            case 1 -> r1.addition(r1,i);
            case 2 -> r1.subtraction(r1,i);
            case 3 -> r1.multiplication(r1,i);
            case 4 -> r1.division(r1,i);
            default -> null;
        };
    }

//    4.-Impresiones
    public void outs(int selection) {
        switch(selection) {
            case 1,2,3,4,5,6,7 -> {
                String results = "Resultado:\n" +  this.r3;
                JOptionPane.showMessageDialog(null, results);
            }
            case 8 -> {
                String results = operatorStr(this.opC, this.operatorflag);
                JOptionPane.showMessageDialog(null, results);
            }
        }
    }

    public static String operatorStr(int op,boolean operatorflag ) {
        String status = operatorflag ? "es VERDADERO" : "es Falso";
        String res = "Resultados del operador: ";

        String opName = switch (op) {
            case 1 -> "1.-Igual" ;
            case 2 -> "2.-Mayor que";
            case 3 ->"3.-Menor que";
            case 4 ->"4.-Mayor igual que";
            case 5 ->"5.-Menor igual que";
            case 6 -> "6.-No igual";
            default -> null;
        };
        res += opName + "es: \n" + status;
        return res;
    }

//  5.- Navegacion
    public int navigation() {
        int selection;
        String sel = "";
        String navMenu = "--- Menú de Opciones (ADT Rational) ---\n" +
                "_____________________________________________\n" +
                "Elige el número de prestación que desea usar:\n" +
                "_____________________________________________\n" +
                "1.- Addition\n" +
                "2.- Subtraction\n" +
                "3.- Multiplication\n" +
                "4.- Division\n" +
                "5.- Exponenciación\n" +
                "6.- Negación\n" +
                "7.- Asignación\n" +
                "8.- Comparación\n" +
                "9.- Salir\n" +
                "______________________________________________\n";

        do {
            do sel = JOp.showInputDialog(null,navMenu,"Menu de opciones");
            while (!isInt(sel));
            selection = Integer.parseInt(sel);
        }while (selection < 1|| selection > 9);
        return selection;
    }

//    Metodo menu reutilizable DRY
    public int menu(String prompt, int min, int max) {
        int resp;

        do {
            resp = Integer.parseInt(JOptionPane.showInputDialog(null,
                    prompt,"Menu de opciones"));
        } while (resp < min || resp > max);
        return resp;
    }
    
    public static void main(String[] args) {
        Prueba prueba = new Prueba();
        prueba.goal();
            int selection ;
        do {
            selection = prueba.navigation();
            if (selection!=9) {
                prueba.data(selection);
                prueba.processes(selection);
                prueba.outs(selection);
            }
            JOptionPane.showMessageDialog(null, "GRACIAS");
        }while(selection != 9);
    }
}