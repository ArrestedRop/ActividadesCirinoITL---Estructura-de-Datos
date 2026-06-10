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

public class MiLista<T> implements ListaADT<T> {
    private Nodo<T> head;
    private int size;

    public MiLista() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void insert(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);

        if (head == null) head = nuevoNodo;
        else {
            Nodo<T> actual = head;
            while (actual.getSiguiente()!=null) actual = actual.getSiguiente();
            actual.setSiguiente(nuevoNodo);
        }
        size++;
    }

    @Override
    public boolean remove(T dato) {
        if (head == null) return false;
        // Si el elemento a borrar es la cabeza
        if (head.getDato().equals(dato)) {
            head = head.getSiguiente();
            size--;
            return true;
        }
        // Buscar en el resto de la lista
        Nodo<T> actual = head;
        while (actual.getSiguiente() != null &&
                !actual.getSiguiente().getDato().equals(dato)) {
            actual = actual.getSiguiente();
        }
        // Si se encontro el elemento
        if (actual.getSiguiente() != null) {
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
            size--;
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {return size == 0;}

    @Override
    public int getSize() {return size;}
}
