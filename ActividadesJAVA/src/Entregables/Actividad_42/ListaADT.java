package Entregables.Actividad_42;

public interface ListaADT<E> {
    void insert(int index, E element);
    E remove(int index);
    void set(int index, E element);
    E get(int index);
    ListaADT<E> concatenar(ListaADT<E> otra);
    boolean isEquals(ListaADT<E> otra);
    int size();
    boolean isEmpty();
}