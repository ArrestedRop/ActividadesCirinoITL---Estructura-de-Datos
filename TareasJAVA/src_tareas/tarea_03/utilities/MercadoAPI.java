package tarea_03.utilities;

public class MercadoAPI {
    public static double variacion(String accion) {
        // Se simula una API que busca la accion y devuelve
        // un multiplicador usando un randomizador
        double variacion  = 0.90 + (Math.random() * 0.20);
        return variacion;
    }
}
