package Entregables.actividades15_19.actividad17;

import java.util.*;
public class Conjunto<T> implements Conjuntable<T> {
    private List<T> elements;
    private int size;

    // Constructors
    public Conjunto() {
        this.elements = new ArrayList<T>();
        this.size = 0;
    }
    
    Conjunto(Conjunto <T> c) {
        this.elements = new ArrayList<>(c.elements);
        this.size = c.size;
    } 

    @Override
    public void addElt(T e) {
        if(!this.elements.contains(e)) {
            this.elements.add(e);
            this.size++;
        }
    }
    @Override
    public void remElt(T e) {
        if(this.elements.contains(e)) {
            this.elements.remove(e);
            this.size--;
        }
    }
    @Override
    public void toEmpty(){
        this.elements.clear();
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean contains(T e) {
        return this.elements.contains(e);
    }

    @Override
    public boolean hasElt() {
        return this.size > 0;
    }

    @Override
    public boolean subSet(Conjuntable<T> c) {
        if ( this.size > c.size()) return false;

        for(T e : this.elements) {
            if(!c.contains(e)) return false;
        }
        return true;
    } 

    @Override
    public Conjuntable <T> union(Conjuntable<T> c) {
        Conjunto<T> result = new Conjunto<>(this);
        Conjunto<T> c2 = new Conjunto<>((Conjunto<T>)c);
        for(T e : c2.elements) {
            result.addElt(e);
        }
        return result;
    }

    @Override
    public Conjuntable <T> interseccion(Conjuntable<T> c) { 
        Conjunto<T> result = new Conjunto<>();
        Conjunto<T> c2 = new Conjunto<T>((Conjunto<T>)c);
        for(T e : this.elements) {
            if (c2.contains(e)) result.addElt(e);
        } 
        return result;
    }
    @Override
    public Conjuntable <T> diferens(Conjuntable<T> c) {
        Conjunto<T> result = new Conjunto<>();
        Conjunto<T> c2 = new Conjunto<T>((Conjunto<T>)c);
        for(T e : this.elements) {
            if (!c2.contains(e)) result.addElt(e);
        }
        return result;
    }
    
}
