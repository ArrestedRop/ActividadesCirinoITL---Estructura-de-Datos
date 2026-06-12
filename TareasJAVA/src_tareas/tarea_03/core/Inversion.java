package tarea_03.core;

import tarea_03.utilities.MercadoAPI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Inversion implements InversionADT {
    private double monto;
    private String acciones;
    private LocalDateTime fechaUltimaOperacion; // Guardamos la fecha y hora

    public Inversion() {}

    // Constructor para facilitar la creacion de una inversion
    public Inversion(String acciones, double monto) {
        this.acciones = acciones;
        // llamamos la inversionAccion
        inversionAccion(monto);
    }

    // Realizamos la inversionAccion
    public void inversionAccion(double monto) {
        this.monto += monto;
        actualizarFecha(); // Cada que se inviertes, se guarda la fecha
    }

    // Se vende la accion
    public void vender(double monto) {
        //validación para que no vendas más de lo que tienes
        if (deuda() || monto > this.monto) {
            System.out.println("No puedes vender mas papu, fondos insuficientes.");
        } else {
            this.monto -= monto;
            actualizarFecha(); // Cada que vendes, se actualiza la fecha
        }
    }

    // chequea si existe deuda
    public boolean deuda() {
        return this.monto <= 0;
    }

    // Actualiza la fecha
    public void actualizarFecha() {
        // Guarda el momento exacto en el que se hace el movimiento
        this.fechaUltimaOperacion = LocalDateTime.now();
    }

    // Actualiza el mercado usando la API, asi sabemos si subio o bajo
    public void actualizarConMercado() {
        // Nos conectamos a la "API" para ver si ganamos o perdimos
        double multiplicador = MercadoAPI.variacion(this.acciones);
        this.monto = this.monto * multiplicador;
    }

    // Permite mostrar los datos deseados
    public void consulta() {
        // Monitoreo constante: Antes de mostrar el saldo, calculamos la subida/bajada
        actualizarConMercado();

        // Damos formato a la fecha para que no se vea fea (ej. 12/05/2026 14:30:00)
        String fechaStr = "Sin registro";
        if (fechaUltimaOperacion != null) {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            fechaStr = fechaUltimaOperacion.format(formato);
        }

        System.out.println("\n--- REPORTE DE INVERSION ---");
        System.out.println("Accion: " + getAcciones());
        System.out.println("Monto actual: $" + String.format("%.2f", getMonto()));
        System.out.println("Ultima operacion: " + fechaStr);
    }

    // Regresa el monto de la accion
    public double getMonto() {return monto;}

    // Regresa el nombre de la accion
    public String getAcciones(){return acciones;}
}