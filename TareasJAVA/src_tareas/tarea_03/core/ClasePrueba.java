package tarea_03.core;
import tarea_03.utilities.Misc;

import java.util.Scanner;

public class ClasePrueba {
    Inversion[] arr = new Inversion[5];
    Scanner sc = new Scanner(System.in);

    // 1 META
    void goal() {
        String msg = "Programa simple que nos permite guardar \n";

        msg += "un portafolio de inversiones y manipularlas usando \n";
        msg += "las prestaciones de la clase encapsulada Inversion, \n";
        msg += "tales como; inversionAccion, vender, deuda, actualizarFecha.\n";
        msg += "etc.\n";
        System.out.println(msg);
    }

    // 2 DATOS (Inicialización Dinámica)
    void configurarPortafolio() {
        String nombre = "", amount;
        double montoInicial;

        System.out.println("--- CONFIGURACION INICIAL DEL PORTAFOLIO ---");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Nombre de la accion " + (i + 1) + ": ");
            nombre = sc.nextLine();

            do {
                System.out.printf("Monto inicial a invertir en %s: ", nombre);
                amount = sc.nextLine();
            } while (!Misc.isInt(amount ) || Integer.parseInt(amount) < 0);

            montoInicial = Double.parseDouble(amount);
            // Use el nuevo constructor
            arr[i] = new Inversion(nombre, montoInicial);
        }
        System.out.println("¡Portafolio configurado exitosamente!\n");
    }

    // 3 PROCESOS
    void proceses(int selection) {
        switch (selection) {
            case 1 -> inversionData();
            case 2 -> selling();
        }
    }

    // Datos necesarios para las inversiones
    void inversionData() {
        String sen = "";
        int opcion;
        String msg;

        while (!sen.equalsIgnoreCase("f")) {
            System.out.println("\n--- MERCADO DE INVERSIONES ---");
            opcion = mercado();
            if (opcion>=1&&opcion<=5){
                opcion--;
                invest(opcion,arr[opcion].getAcciones());
            }

            msg = "Escriba 'f' para terminar el registro ";
            msg += "u otra tecla para continuar:";
            System.out.println(msg);
            sen = sc.nextLine();
        }
    }

    // Metodo que nos permite usar la prestacion invertirAccion
    // De manera apropiada
    void invest(int indexx, String share) {
        String amount;

        do {
            System.out.printf("Proporcione el monto a invertir en %s: ",share);
            amount = sc.nextLine();
        } while (!Misc.isInt(amount));

        // Ajustado al nombre del metodo en el nuevo ADT (inversion)
        arr[indexx].inversionAccion(Double.parseDouble(amount));
        System.out.printf("Usted ha invertido exitosamente en: %s\n",share);
    }

    // Metodo que auxilia el metodo proceso, esto con el fin de
    // Simplificar la algoritmia de  procesos
    void selling() {
        int option;

        System.out.println("\n--- VENTA DE ACCIONES ---");
        option = mercado();
        if (option >= 1 && option <= 5) {
            option--;
            sell(option, arr[option].getAcciones());
        }
    }

    // Metodo que nos permite usar la prestacion vender
    // De manera apropiada
    void sell(int indexx, String share) {
        String amount;
        double amountd;
        String msg;

        do {
            System.out.printf("Monto actual de %s", share);
            System.out.println("\t--> [" + arr[indexx].getMonto() + "]" );
            System.out.printf("Proporcione el monto a vender de %s: ", share);
            amount = sc.nextLine();
        } while (!Misc.isInt(amount));
        amountd = Double.parseDouble(amount);

        // Se verifica en el main, aunque la clase Inversion tambien lo protege ahora
        if (amountd <= 0 || arr[indexx].deuda()
                || arr[indexx].getMonto() < amountd) {
            msg = "No puedes vender esa cantidad. Fondos ";
            msg += "insuficientes o estas en deuda, pobre.";
            System.out.println(msg);
        } else {
            arr[indexx].vender(amountd);
            msg = "Usted ha vendido [" + amountd + "] de " + share;
            System.out.println(msg);
        }
    }

    // 4 SALIDAS
    void outPut(int selection) {
        switch (selection) {
            case 3 -> debt();
            case 4 -> consultation();
        }
    }

    // Metodo creado para simplificar la algoritmia del metodero outPut
    void debt() {
        int option;

        System.out.println("\n--- CONSULTA DE DEUDA ---");
        option = mercado();
        if (option >= 1 && option <= 5) debtChecking(option - 1);
    }

    // Metodo que nos auxilia con el chequeo de la deuda
    void debtChecking(int indexx) {
        String msg;

        // La consulta de deuda también se verá afectada si el mercado los dejó en 0
        if (arr[indexx].deuda()) {
            msg = "La cuenta de " + arr[indexx].getAcciones();
            msg += " esta en ceros o en deuda.";
            System.out.println(msg);
        } else {
            msg = "Todo en orden. La cuenta de ";
            msg += arr[indexx].getAcciones() + " tiene fondos positivos.";
            System.out.println("\n-------------------------");
            System.out.print(msg);
            System.out.println("-------------------------");

        }
    }

    // Nos permite revisar generalmente la accion
    void consultation() {
        int option;

        System.out.println("\n--- CONSULTA GENERAL DE ACCION ---");
        option = mercado();
        if (option >= 1 && option <= 5) {
            System.out.println("\n-------------------------");
            arr[option - 1].consulta(); // Esto ahora actualiza el precio con la "API"
            System.out.println("-------------------------");
        }
    }

    // 5 NAVEGACION
    // Menu principal, usa la prestacion menuCreator de la clase Misc
    // esto con el fin de hacer mas simple el despliegue en terminal
    // de un menu "interactivo"
    int principalMenu() {
        String msg = "\n=== MENU DE OPCIONES ===\n";

        msg += "1.- Invertir en una accion\n";
        msg += "2.- Vender en una accion\n";
        msg += "3.- Consulta de deuda\n";
        msg += "4.- Consulta info de la accion (Abre el mercado)\n";
        msg += "5.- Salir\n";
        return Misc.menuCreator(msg, 5);
    }

    // Menu secundario, usa la prestacion menuCreator de la clase Misc
    // esto con el fin de hacer mas simple el despliegue en terminal
    // de un menu "interactivo"
    int mercado() {
        // Ahora el mercado es dinámico, se adapta a lo que ingresó el usuario
        String msg = "--- LISTA DE ACCIONES ---\n";
        for (int i = 0; i < arr.length; i++)
            msg += (i + 1) + ".- " + arr[i].getAcciones() + "\n";
        return Misc.menuCreator(msg, arr.length);
    }


    // Metodo de corrida, la culminacion de lo previamente estructurado
    // Sirve para sincronizar cada uno de los metodos propuestos
    public void run() {
        int opc;
        String bye;

        goal();
        configurarPortafolio();
        do {
            opc = principalMenu();
            proceses(opc);
            outPut(opc);
        } while (opc != 5);

        bye = "Saliendo del sistema de inversiones... ";
        bye += "¡Nos vemos, lobo de Wall Street!";
        System.out.println(bye);
    }

    public static void main(String[] args) {
        ClasePrueba cp = new ClasePrueba();
        cp.run();
    }

}