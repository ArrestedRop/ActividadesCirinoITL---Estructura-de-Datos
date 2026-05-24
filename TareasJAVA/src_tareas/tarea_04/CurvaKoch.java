package tarea_04;
/*
Tecnológico Nacional de México
Instituto Tecnológico de León
Ingeniería en Sistemas Computacionales
Estructuras de datos
Lunes y miercoles 7:00 a 8:45
viernes 7:00 a 7:50
Alumno: Villagomez Magaña Maximo Javier
Tarea 4 (Curva Fractal - Curva de Koch)
Fecha: 1/6/2026
*/

/*
Tecnológico Nacional de México
Instituto Tecnológico de León
Ingeniería en Sistemas Computacionales
Estructuras de datos
Lunes y miercoles 7:00 a 8:45
viernes 7:00 a 7:50
Alumno: Villagomez Magaña Maximo Javier
Tarea 4 (Curva Fractal - Curva de Koch)
Fecha: 1/6/2026
*/

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

// Heredamos de JPanel para que esta clase actúe como nuestro lienzo de dibujo
public class CurvaKoch extends JPanel {
    int orden;
    float distancia;
    Scanner scanner;

    float currentX;
    float currentY;
    int currentAngle;

    public CurvaKoch() {scanner = new Scanner(System.in);}

    // 1. METODO goal()
    public void goal() {
        String msg ="Script que dibuja la curva de Koch de manera recursiva ";

        msg +="Se abrira una ventana de Java Swing para mostrar el grafico.\n";
        System.out.println(msg);
    }

    // 2. METODO data()
    public void data() {
        String msg = "Deme el nivel de profundidad de la curva fractal: ";

        System.out.print(msg);
        while (!scanner.hasNextInt()) {
            msg = "Entrada invalida. Por favor ingrese un numero entero.";
            System.out.println(msg);
            scanner.next();
        }
        orden = scanner.nextInt();
        msg = "De la longitud en pixeles para el segmento inicial (ej. 500): ";
        System.out.print(msg);
        while (!scanner.hasNextFloat()) {
            msg = "Entrada invalida. Por favor ingrese un numero.";

            System.out.println(msg);
            scanner.next();
        }
        distancia = scanner.nextFloat();
    }

    // 3. PROCESOS
    // 3.1 METODO drawKoch
    public void drawKoch(int nivel, float dist, Graphics2D g) {
        if (nivel == 0) avanzar(dist, g);
        else {
            float nuevaDist = dist / 3.0f;

            drawKoch(nivel - 1, nuevaDist, g);
            gira(60);   // Girar a la izquierda
            drawKoch(nivel - 1, nuevaDist, g);
            gira(-120); // Girar a la derecha para bajar el pico
            drawKoch(nivel - 1, nuevaDist, g);
            gira(60);   // Girar a la izquierda para enderezar

            drawKoch(nivel - 1, nuevaDist, g);
        }
    }

    // 3.2 METODO avanzar
    public void avanzar(float dist, Graphics2D g) {
        float radianes = (float) Math.toRadians(currentAngle);
        float newX = currentX + dist * (float) Math.cos(radianes);
        float newY = currentY - dist * (float) Math.sin(radianes);

        g.draw(new Line2D.Float(currentX, currentY, newX, newY));

        currentX = newX;
        currentY = newY;
    }

    // 3.3 METODO gira
    public void gira(int angulo) {currentAngle += angulo;}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        currentX = 100;
        currentY = getHeight() - 200;
        currentAngle = 0;

        drawKoch(orden, distancia, g2d);
    }

    // 4. SALIDA
    // 4.1 METODO canvas()
    public void canvas() {
        String msg = "\nAbriendo la ventana grafica... ";
        System.out.println(msg);

        JFrame frame = new JFrame("Curva de Koch - Tarea 4");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600); // Tamaño de la ventana
        frame.setLocationRelativeTo(null); // Centrar en la pantalla

        frame.add(this);

        frame.setVisible(true);
    }

    // 5. NAVEGACION
    // 5.1 METODO navigation()
    public void navigation() {
        goal();
        data();
        canvas();
    }

    // METODO main()
    public static void main(String[] args) {
        CurvaKoch app = new CurvaKoch();
        app.navigation();
    }
}
