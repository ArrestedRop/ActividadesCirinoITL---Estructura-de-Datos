package Entregables.Actividad_42;

public class MiLista<E> implements ListaADT<E> {
    private Object[] datos;
    private int cantidad;

    public MiLista() {
        this.datos = new Object[10]; // Capacidad inicial base
        this.cantidad = 0;
    }

    public MiLista(int capacidad) {
        if (capacidad <= 0) capacidad = 10;
        this.datos = new Object[capacidad];
        this.cantidad = 0;
    }

    public MiLista(MiLista<E> otra) {
        this.datos = new Object[otra.datos.length];
        this.cantidad = otra.cantidad;
        for (int i = 0; i < cantidad; i++) this.datos[i] = otra.datos[i];
    }

    @Override
    public void insert(int index, E element) {
        if (index < 0 || index > cantidad) return;
        if (cantidad == datos.length) expandirMemoria();
        for (int i = cantidad; i > index; i--) {datos[i] = datos[i - 1];}
        datos[index] = element;
        cantidad++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index < 0 || index >= cantidad) return null;
        E elementoEliminado = (E) datos[index];

        for (int i = index; i < cantidad - 1; i++) {datos[i] = datos[i + 1];}
        datos[cantidad - 1] = null;
        cantidad--;
        return elementoEliminado;
    }

    @Override
    public void set(int index, E element) {
        if (index >= 0 && index < cantidad) datos[index] = element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index >= 0 && index < cantidad) return (E) datos[index];
        return null;
    }

    @Override
    public ListaADT<E> concatenar(ListaADT<E> otra) {
        MiLista<E> nuevaLista = new MiLista<>(this.size() + otra.size());

        for (int i = 0; i < this.size(); i++)
            nuevaLista.insert(nuevaLista.size(), this.get(i));
        for (int i = 0; i < otra.size(); i++)
            nuevaLista.insert(nuevaLista.size(), otra.get(i));

        return nuevaLista;
    }

    @Override
    public boolean isEquals(ListaADT<E> otra) {
        if (this.size() != otra.size()) return false;
        for (int i = 0; i < this.size(); i++) {
            if (!this.get(i).equals(otra.get(i))) return false;
        }
        return true;
    }

    @Override
    public int size() {return cantidad;}

    @Override
    public boolean isEmpty() {return cantidad == 0;}

    private void expandirMemoria() {
        Object[] nuevoArreglo = new Object[datos.length * 2];
        for (int i = 0; i < datos.length; i++) nuevoArreglo[i] = datos[i];
        datos = nuevoArreglo;
    }
}
