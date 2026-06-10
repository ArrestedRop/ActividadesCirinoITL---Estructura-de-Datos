package Entregables.Actividad_44;

import java.util.Scanner;

public class TestMyArrayList {
    MyArrayList<String> myList;
    Scanner sc = new Scanner(System.in);

    // 1 META
    void meta() {
        String msg = "Este script permite manipular una lista\n";

        msg += "dinamica de forma interactiva utilizando las\n";
        msg += "prestaciones de la clase encapsulada MyArrayList.\n";
        System.out.println("--- PRUEBA INTERACTIVA DE MYARRAYLIST ---");
        System.out.println(msg);
    }

    // 2 DATOS
    void datos(int n) {
        myList = new MyArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Elemento [" + i + "]: ");
            myList.add(sc.nextLine());
        }
    }

    // 3 PROCESOS
    void procesos(int opcion) {
        switch (opcion) {
            case 1: agregarElemento(); break;
            case 2: reemplazarElemento(); break;
            case 3: eliminarElemento(); break;
            case 4: buscarContenido(); break;
            case 5: buscarIndice(); break;
            case 6: imprimirLista(); break;
        }
    }

    void agregarElemento() {
        System.out.print("Indice a inyectar: ");
        if (sc.hasNextInt()) {
            int idx = sc.nextInt();
            sc.nextLine(); // Limpiar salto
            System.out.print("Valor a agregar: ");
            String val = sc.nextLine();

            if (idx >= 0 && idx <= myList.size()) myList.add(idx, val);
            else System.out.println("[!] Error: Indice fuera de limites.");
        } else {
            System.out.println("[!] Error: Indice invalido.");
            sc.next(); // Limpiar la basura ingresada
        }
    }

    void reemplazarElemento() {
        System.out.print("Indice a reemplazar: ");
        if (sc.hasNextInt()) {
            int idx = sc.nextInt();
            sc.nextLine(); // Limpiar salto
            System.out.print("Nuevo valor: ");
            String val = sc.nextLine();

            if (idx >= 0 && idx < myList.size()) myList.set(idx, val);
            else System.out.println("[!] Error: Indice fuera de limites.");
        } else {
            System.out.println("[!] Error: Indice invalido.");
            sc.next();
        }
    }

    void eliminarElemento() {
        System.out.print("Indice a eliminar: ");
        if (sc.hasNextInt()) {
            int idx = sc.nextInt();
            sc.nextLine(); // Limpiar salto

            if (idx >= 0 && idx < myList.size()) myList.remove(idx);
            else System.out.println("[!] Error: Indice fuera de limites.");
        } else {
            System.out.println("[!] Error: Indice invalido.");
            sc.next();
        }
    }

    void buscarContenido() {
        System.out.print("Elemento a buscar: ");
        System.out.println("Resultado: " + myList.contains(sc.nextLine()));
    }

    void buscarIndice() {
        System.out.print("Elemento a buscar indice: ");
        System.out.println("Indice: " + myList.indexOf(sc.nextLine()));
    }

    // 4 SALIDAS
    void outPut() {
        System.out.println("\n--- ESTADO FINAL ---");
        System.out.println("Lista: " + myList.toString());
        System.out.println("Tamaño: " + myList.size());

        String bye = "Saliendo del sistema de listas dinámicas... ";
        bye += "¡Nos vemos, lobo de la programación!";
        System.out.println(bye);
    }

    void imprimirLista() {
        System.out.println("Lista: " + myList.toString());
    }

    // 5 NAVEGACION
    int principalMenu() {
        System.out.println("\n--- MENU DE OPERACIONES ---");
        System.out.println("1. Agregar elemento (Inyectar)");
        System.out.println("2. Reemplazar elemento (Set)");
        System.out.println("3. Eliminar elemento (Remove)");
        System.out.println("4. Revisar si contiene");
        System.out.println("5. Buscar indice");
        System.out.println("6. Ver lista actual");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opcion: ");

        if (sc.hasNextInt()) {
            int opc = sc.nextInt();
            sc.nextLine(); // Limpiar salto de línea
            return opc;
        } else {
            System.out.println("[!] Error: Ingrese solo numeros para el menú.");
            sc.next(); // Consumir la letra/palabra ingresada
            sc.nextLine();
            return 0;
        }
    }

    public void run() {
        int opc = 0;
        int n = -1;

        meta();
        do {
            System.out.print("¿Cuantos elementos iniciales desea agregar?: ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                sc.nextLine();
                if (n < 0) {
                    System.out.println("No se permiten numeros negativos.");
                }
            } else {
                System.out.println("Entrada no valida, ingrese un numero entero.");
                sc.next();
            }
        } while (n < 0);
        datos(n);
        do {
            opc = principalMenu();
            procesos(opc);
        } while (opc != 7);

        outPut();
    }

    public static void main(String[] args) {
        new TestMyArrayList().run();
    }
}