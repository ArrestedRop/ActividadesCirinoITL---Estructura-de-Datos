package tarea_03;
import java.util.Scanner;

public class ClasePrueba {
    Inversion[] arr = new Inversion[5];
    Scanner sc = new Scanner(System.in);

    public ClasePrueba() {
        for (int i = 0; i < arr.length; i++) arr[i] = new Inversion();
        setArr();
    }

    // 1 META
    void goal() {
        String msg = "Programa simple que nos permite guardar un grupo de \n";

        msg += "inversiones y manipularla ligeramente con sus propias ";
        msg += "prestaciones\n";
        System.out.println(msg);
    }

    // 2 DATOS
    void setArr() {
        arr[0].setAcciones("SpaceEx");
        arr[1].setAcciones("Pollo Felix");
        arr[2].setAcciones("Abarrotes DC");
        arr[3].setAcciones("Bodega A");
        arr[4].setAcciones("ITL");
    }

    // 3 PROCESOS
    void proceses(int selection) {
        switch (selection) {
            case 1 -> inversionData();
            case 2 -> selling();
        }
    }

    void inversionData() {
        String sen = "";
        int opcion;
        String msg;

        while (!sen.equalsIgnoreCase("f")) {
            System.out.println("\n--- MERCADO DE INVERSIONES ---");
            opcion = mercado();
            if (opcion >= 1 && opcion <= 5)
                invest(opcion - 1, arr[opcion - 1].getAcciones());

            msg = "Escriba 'f' para terminar el registro ";
            msg += "u otra tecla para continuar:";
            System.out.println(msg);

            sen = sc.nextLine();
        }
    }

    void invest(int indexx, String share) {
        String amount;

        do {
            System.out.printf("Proporcione el monto a invertir en %s: ", share);
            amount = sc.nextLine();
        } while (!Misc.isInt(amount));

        arr[indexx].inversion(Double.parseDouble(amount));
        System.out.printf("Usted ha invertido exitosamente en: %s\n", share);
    }

    void selling() {
        int option;

        System.out.println("\n--- VENTA DE ACCIONES ---");
        option = mercado();
        if (option >= 1 && option <= 5) {
            sell(option - 1, arr[option - 1].getAcciones());
        }
    }

    void sell(int indexx, String share) {
        String amount;
        double amountd;
        String msg;

        do {
            System.out.printf("Proporcione el monto a vender de %s: ", share);
            amount = sc.nextLine();
        } while (!Misc.isInt(amount));
        amountd = Double.parseDouble(amount);

        if (amountd <= 0 || arr[indexx].deuda()
                || arr[indexx].getMonto() < amountd) {
            msg = "No puedes vender esa cantidad. Fondos ";
            msg += "insuficientes o estás en deuda, pobre.";
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

    void debt() {
        int option;

        System.out.println("\n--- CONSULTA DE DEUDA ---");
        option = mercado();
        if (option >= 1 && option <= 5) debtChecking(option - 1);
    }

    void debtChecking(int indexx) {
        String msg;

        if (arr[indexx].deuda()) {
            msg = "La cuenta de " + arr[indexx].getAcciones();
            msg += " esta en ceros o en deuda.";
            System.out.println(msg);
        } else {
            msg = "Todo en orden. La cuenta de ";
            msg += arr[indexx].getAcciones() + " tiene fondos positivos.";
            System.out.println(msg);
        }
    }

    void consultation() {
        int option;

        System.out.println("\n--- CONSULTA GENERAL DE ACCION ---");
        option = mercado();
        if (option >= 1 && option <= 5) {
            System.out.println("-------------------------");
            arr[option - 1].consulta();
            System.out.println("-------------------------");
        }
    }

    // 5 NAVEGACION
    int principalMenu() {
        String msg = "\n=== MENU DE OPCIONES ===\n";

        msg += "1.- Invertir en una accion\n";
        msg += "2.- Vender en una accion\n";
        msg += "3.- Consulta de deuda\n";
        msg += "4.- Consulta info de la accion\n";
        msg += "5.- Salir\n";
        return Misc.menuCreator(msg, 5);
    }

    int mercado() {
        String msg = "1.- SpaceEx: En ascenso\n";

        msg += "2.- Pollo felix: Basura\n";
        msg += "3.- Abarrotes DC: Tablas\n";
        msg += "4.- Bodega A: En ascenso\n";
        msg += "5.- ITL: Mal\n";
        return Misc.menuCreator(msg, 5);
    }

    public void run() {
        int opc;
        String bye;

        goal();
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