package tarea_03;

public interface InversionADT {
    void inversion(double monto);
    void vender(double monto);
    void consulta();
    boolean deuda();
    void setAcciones(String acciones);
    double getMonto();
    String getAcciones();
}
