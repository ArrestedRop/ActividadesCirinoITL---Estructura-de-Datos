package Entregables.actividades21_24.actividad24.Core;

public class Persona {
    private int numero;
    private String nombre;

    public Persona(int numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }

    public Persona() {}

    public boolean setNumero(int numero) {
        if(numero<0) return false;
        else {
            this.numero = numero;
            return true;
        }
    }

    public boolean setNombre(String nombre) {
        if (nombre == null||nombre.isEmpty())
            return false;
        else {
            this.nombre = nombre;
            return true;
        }
    }

    public int getNumero() {return numero;}
    public String getNombre() {return nombre;}
}
