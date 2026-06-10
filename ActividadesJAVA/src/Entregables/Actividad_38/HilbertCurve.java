package Entregables.Actividad_38;

/*
Tecnológico Nacional de México
Instituto Tecnológico de León
Ingeniería en Sistemas Computacionales
Estructuras de datos
Lunes y miercoles 7:00 a 8:45
viernes 7:00 a 7:50
Alumno: Villagomez Magaña Maximo Javier
Tarea 38
Fecha: 12/5/2026
*/

import java.awt.Graphics;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HilbertCurve extends JPanel {
    static int orden;
    static float distancia;
    static Scanner scanner = new Scanner(System.in);
    double tX;
    double tY;
    double anguloActual;

    // 1. METAS
    public static void goal() {
        String msg = "Script que recibe el nivel y la longitud de pixeles ";
        msg += "para dibujar la curva de Hilbert gráficamente\n";
        msg += "utilizando JFrame y JPanel (Java Swing).\n";
        System.out.println(msg);
    }

    // 2. DATOS
    public static void data() {
        // Ahora el método data es súper directo y delega el trabajo pesado a los validadores
        orden = leerEnteroValidado("Deme el nivel (orden) de la curva fractal (>= 0): ");
        distancia = leerFlotanteValidado("Deme la longitud en pixeles (segmento >= 0): ");
    }

    // --- MÉTODOS DE VALIDACIÓN ---
    public static int leerEnteroValidado(String mensaje) {
        int valor;
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                if (valor >= 0) {
                    return valor; // Si es válido, lo devuelve y sale del ciclo
                } else {
                    System.out.println("Error: El nivel no puede ser menor a cero. Intente de nuevo.\n");
                }
            } else {
                System.out.println("Error: Entrada invalida. Ingrese un numero entero (no letras).\n");
                scanner.next(); // Limpia el buffer del escáner
            }
        }
    }

    public static float leerFlotanteValidado(String mensaje) {
        float valor;
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextFloat()) {
                valor = scanner.nextFloat();
                if (valor >= 0) {
                    return valor; // Si es válido, lo devuelve y sale del ciclo
                } else {
                    System.out.println("Error: La longitud no puede ser menor a cero. Intente de nuevo.\n");
                }
            } else {
                System.out.println("Error: Entrada invalida. Ingrese un numero (no letras).\n");
                scanner.next(); // Limpia el buffer del escáner
            }
        }
    }

    // 3. PROCESOS
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        tX = 20;
        tY = 20;
        anguloActual = 0;
        drawHilbert(g, orden, 90);
    }

    public void drawHilbert(Graphics g, int nivel, int angulo) {
        if (nivel == 0) return;
        gira(angulo);
        drawHilbert(g, nivel - 1, -angulo);
        avanzar(g, distancia);
        gira(-angulo);
        drawHilbert(g, nivel - 1, angulo);
        avanzar(g, distancia);
        drawHilbert(g, nivel - 1, angulo);
        gira(-angulo);
        avanzar(g, distancia);
        drawHilbert(g, nivel - 1, -angulo);
        gira(angulo);
    }

    public void avanzar(Graphics g, float dist) {
        double rad = Math.toRadians(anguloActual);
        double nextX = tX + (dist * Math.cos(rad));
        double nextY = tY + (dist * Math.sin(rad));

        g.drawLine((int) tX, (int) tY, (int) nextX, (int) nextY);
        tX = nextX;
        tY = nextY;
    }

    public void gira(int angulo) {anguloActual += angulo;}

    // 4. SALIDA
    public static void canvas() {
        System.out.println("\nINICIALIZANDO LIENZO GRAFICO...");
        JFrame frame = new JFrame("Curva de Hilbert - Tortuga Grafica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.add(new HilbertCurve());
        frame.setVisible(true);
    }

    // 5. NAVEGACION
    public static void navigation() {
        goal();
        data();
        canvas();
    }

    public static void main(String[] args) {navigation();}
}