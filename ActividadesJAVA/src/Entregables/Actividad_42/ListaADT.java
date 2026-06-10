/*
Tecnológico Nacional de México
Instituto Tecnológico de León
Ingeniería en Sistemas Computacionales
Estructuras de datos
Lunes y miercoles 7:00 a 8:45
viernes 7:00 a 7:50
Alumno: Villagomez Magaña Maximo Javier
Tarea 42
Fecha: 27/5/2026
*/

package Entregables.Actividad_42;

public interface ListaADT<T> {
    public void insert(T dato);

    // Ajustado a boolean para coincidir con la implementacion de MiLista
    public boolean remove(T dato);

    public int getSize();

    public boolean isEmpty();
}