
import java.util.Scanner;

public class RegistroManual {

    private int cuenta = 0;

    public Persona[] data() {
        Scanner lectura = new Scanner(System.in);
        Persona[] grupo = new Persona[25];

        String nombre;
        int numero_de_control;
        String fecha_de_nacimiento;
        double estatura;
        double peso;

    System.out.println("Proporcione el nombre de la persona o escriba \"fin\" para terminar \n");
    nombre = lectura.nextLine();

    while (!nombre.equalsIgnoreCase("fin")  && this.cuenta < grupo.length) {
        try {
            System.out.println("De # de control:\n");
            numero_de_control = Integer.parseInt(lectura.nextLine());

            System.out.println("De Fecha de Nacimiento:\n");
            fecha_de_nacimiento = lectura.nextLine();

            System.out.println("Peso de la persona:\n");
            peso = Double.parseDouble(lectura.nextLine());

            System.out.println("Estatura de la persona:\n");
            estatura = Double.parseDouble(lectura.nextLine());

            grupo[cuenta] = new Persona(nombre, fecha_de_nacimiento, estatura, peso, numero_de_control);
            this.cuenta++;
            System.out.println("Persona registrada con exito\n");

                if (cuenta < grupo.length) {
                System.out.println("Proporcione el siguiente nombre o escriba \"fin\" para terminar \n");
                nombre = lectura.nextLine();
                }

    }catch (NumberFormatException e){
        System.out.println("Error: Ingresaste texto en un campo numérico (Peso, Estatura o Control).");
        System.out.println("Por favor, vuelve a ingresar los datos de " + nombre + " correctamente.");
        }
    }
return grupo;
    }

    public int getCuenta() {
        return this.cuenta;
    }

}
