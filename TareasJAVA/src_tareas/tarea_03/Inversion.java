package tarea_03;

public class Inversion implements InversionADT {
    private double monto;
    private String acciones;

    Inversion() {}
    public void setAcciones(String acciones) {this.acciones = acciones;}

    public void inversion(double monto) {
        this.monto += monto;
    }

    public void vender(double monto) {
        if (deuda()) System.out.println("No puedes vender mas papu");
        else this.monto -= monto;
    }

    public boolean deuda() {
        if (this.monto <= 0) return true;
        else return false;
    }

    public void consulta() {
        System.out.println("Accion: "+getAcciones() + "\nMonto: "+getMonto());
    }

    public double getMonto() {return monto;}
    public String getAcciones(){return acciones;}
}
