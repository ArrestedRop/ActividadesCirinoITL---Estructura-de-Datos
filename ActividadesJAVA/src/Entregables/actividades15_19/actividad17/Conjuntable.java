package Entregables.actividades15_19.actividad17;

public interface Conjuntable<T> {
    void addElt(T e);
    void remElt(T e);
    void toEmpty();

    int size();
    boolean contains(T e);
    boolean hasElt();
    boolean subSet(Conjuntable<T> c); 

    Conjuntable <T> union(Conjuntable<T> c);
    Conjuntable <T> interseccion(Conjuntable<T> c);
    Conjuntable <T> diferens(Conjuntable<T> c);
}
