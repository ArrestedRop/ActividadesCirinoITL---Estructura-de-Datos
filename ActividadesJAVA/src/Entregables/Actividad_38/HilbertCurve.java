package Entregables.Actividad_38;

/*
Tecnológico Nacional de México
Instituto Tecnológico de León
Ingeniería en Sistemas Computacionales
Estructuras de datos
Lunes y miercoles 7:00 a 8:45
viernes 7:00 a 7:50
Alumno: Villagomez Magaña Maximo Javier
Tarea 31
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
        String msg = "Script que dibuja la curva de Hilbert gráficamente\n";

        msg += "utilizando JFrame y JPanel (Java Swing).\n";
        System.out.println(msg);
    }

    // 2. DATOS
    public static void data() {
        System.out.print("Deme el nivel (orden) de la curva fractal: ");
        while (!scanner.hasNextInt()) {
            String err = "Entrada invalida. Ingrese un numero entero.";
            System.out.println(err);
            scanner.next();
        }
        orden = scanner.nextInt();

        System.out.print("Deme la longitud en pixeles (segmento): ");
        while (!scanner.hasNextFloat()) {
            String err = "Entrada invalida. Ingrese un numero decimal.";
            System.out.println(err);
            scanner.next();
        }
        distancia = scanner.nextFloat();
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
