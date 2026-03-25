package Entregables.actividades15_19.actividad17;

public interface Conjuntable<T> {
    void addElt(T e);
    void remElt(T e);
    void toEmpty();

    int size();
    boolean contains(T e);
    boolean hasElt();

    Conjuntable <T> union()
}
