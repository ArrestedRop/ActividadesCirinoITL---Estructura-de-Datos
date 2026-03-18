package Entregables.actividad_13y14;
import javax.swing.*;
import static Entregables.actividad_13y14.Misc.*;

public class Prueba {
//    1.- Meta
    public void goal() {
        JOptionPane.showMessageDialog(null
                ,"Programa que busca poner a prueba cada una de" +
                " las capacidades dentro del Abstract Data Type Rational");
    }
//    2.- Data
    Rational r1, r2, r3;
    int i, exp, opA, opC;
    boolean operatorflag;

    public void data(int selection) {
        switch(selection) {
            case 1,2,3,4 -> {
                this.opA = menu("1.- Aritmetica de quebrados\n" +
                        "2.-Aritmetica de quebrados y enteros\n" +
                        "3.- No hacer nada",1,3);
                capturar2(opA);
            }
            case 5 -> {
                r1 = capturarRat();
                exp = capturarInt("exponente");}
            case 6,7 -> r1 = capturarRat();
            case 8 -> {
                this.opC = menu("1.- Igual\n2.- Mayor que\n3.- Menor que\n" +
                        "4.- Mayor igual\n5.- Menor igual\n6.- No igual", 1, 6);
                r1 = capturarRat();
                r2 = capturarRat();
            }
        }
    }
//    Capturadores de INT y RATIONALs
    public static int capturarInt(String prompt) {
        String ent;
        do {
            ent = JOptionPane.showInputDialog(null,
                    "Proporcione el " + prompt, "Capturador de Operadores");
        }while(!isInt(ent));
        return Integer.parseInt(ent);
    }

    public static Rational capturarRat() {
        String x;
        String y;
        do {
            x = JOptionPane.showInputDialog(null,
                    "Proporcione el numerador", "Capturador de Operadores");
        } while (!isInt(x));
        do {
            y = JOptionPane.showInputDialog(null,
                    "Proporcione el denominador", "Capturador de Operadores");
        }while(!isInt(y));
        return new Rational(Integer.parseInt(x),Integer.parseInt(y));
    }

    public void capturar2(int op) {
        if (op == 1) {
            this.r1 = capturarRat();
            this.r2 = capturarRat();
        }
        else {
            this.r1 = capturarRat();
            this.i = capturarInt("Numero Entero");
        }
    }

//    3.- Procesos
    public void processes(int selection) {
        if (selection < 8) {
            this.r3 = switch(selection) {
                case 1, 2, 3, 4 -> (this.opA == 1) ? aritmethics(selection, r1, r2):mixture(selection, r1,i);
                case 5 -> r1.exponentiation(r1,exp);
                case 6 -> r1.negation(r1);
                case 7 -> r1.assignment(capturarRat());
                default -> null;
                };
            }
        else {
            this.operatorflag = ratOperators(opC,r1,r2);
        }
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
        String opName = switch (op) {
            case 1 -> "1.-Igual" ;
            case 2 -> "2.-Mayor que";
            case 3 ->"3.-Menor que";
            case 4 ->"4.-Mayor igual que";
            case 5 ->"5.-Menor igual que";
            case 6 -> "6.-No igual";
            default -> null;
        };
        String status = operatorflag ? "es VERDADERO" : "es Falso";
        return "Resultados del operador: " + opName +
                "es: \n" + status;
    }
//  5.- Navegacion
    public int navigation() {
        int selection;
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
            selection = Integer.parseInt(JOptionPane.showInputDialog(null,
                    navMenu,"Menu de opciones"));
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