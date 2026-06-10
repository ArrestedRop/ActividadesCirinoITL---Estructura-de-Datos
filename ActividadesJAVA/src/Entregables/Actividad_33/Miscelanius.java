package Entregables.Actividad_33;

import java.util.Scanner;

public class Miscelanius {

    private Scanner sc = new Scanner(System.in);

    // Captures whole numbers (integers) safely
    public int capInt(String prompt) {
        int value = 0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.print(prompt);
                value = Integer.parseInt(sc.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a valid whole number.");
            }
        }
        return value;
    }

    // Captures decimal numbers (doubles) safely
    public double capReal(String prompt) {
        double value = 0.0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.print(prompt);
                value = Double.parseDouble(sc.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a valid decimal number.");
            }
        }
        return value;
    }
}
