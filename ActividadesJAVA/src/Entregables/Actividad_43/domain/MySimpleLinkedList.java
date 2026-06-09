/* /home/cir/Escritorio/cir/apuntes/datastruct/ 
   java/cairo/listas/tres capas/paq3paq/domain/MySimpleLinkedList.java
   depurado el 12 de enero 2026
*/
   
package Entregables.Actividad_43.domain;

import java.util.*;

public class MySimpleLinkedList implements Listable {
  // the reference to the first node is enough
  // to characterize a list
  protected Node first;

  // a list is created in an empty state
  public MySimpleLinkedList() {  first = null;  }
  public void vaciar() {  first = null;  }

  // the new element is located before the
  // former first node
  public void insert(Object o) {
    // step by step code. Could be done in less lines
    // a node that stores the object and links nowhere
    Node tmp = new Node(o, null);

    // the following sentence has no problem with null values of "first"
    tmp.setNext(first);
    // we move the "first" reference
    first = tmp;
  }

  /*======================================================
    Crea un nuevo elemento en la lista l en la posición p,
    desplazando el existente una posición más adelante. Si p
    es la posición final crea un nuevo elemento al final de la lista.
    Precondición: p debe ser una posición válida de la lista.
    =====================================================*/
  void InsertarElemento (Node n, Node p, MySimpleLinkedList l) {
    Node q;

    q = n;
    q.setNext(p.getNext());
    p.setNext(q);
  }

  // extracts the first element and returns its object
  public Object extract() {  
    Object out = null;
    
    if (!isEmpty()) {  // if first is null, you cannot call its methods
      out = first.getInfo();
      first = first.getNext();
    }
    // if the list is empty, null should be returned, but this is
    // the default value of "out"
    return out;
  }

  public Node buscar (Object dato) {  //Feb'10
    Node pos = first;

    while(pos != null && !pos.getInfo().equals(dato)) 
      pos = pos.getNext();
    return pos;
  }

  public void sustituir(Object orig, Object nuevo) {
    Node n = buscar(orig);
    String aux = "El elemento "+orig;

    if ( n!= null) n.setInfo(nuevo);
    else 
      throw new NoSuchElementException(aux+ " no está en la lista");
  }

  public void print(int n) {    
    if (!isEmpty()) {  // if the list is empty, do nothing
      Node tmp = first;

      // iterates until i reaches n or the list is finished.
      for (int i = 0; i < n; i++) {
        tmp = tmp.getNext();
        if (tmp == null)
          return; // the list is finished
      }
      System.out.println(tmp.getInfo());
    }
  }

  public void print() {    
    if (!isEmpty()) {  // if the list is empty, do nothing
      Node tmp = first;
      
      while (tmp != null) {  // iterates until the list is finished
        System.out.println(tmp.getInfo());
        tmp = tmp.getNext();
      }
    }
  }

  public boolean contiene(Object dato) {
    Node pos = first;

    while(pos != null && !dato.equals(pos.getInfo())) 
      pos = pos.getNext();
    return pos != null;
  }

  public int tamaño() {
    int nelem = 0;
    
    if (!isEmpty()) {  // if the list is empty, do nothing
      Node tmp = first;
      
      while (tmp != null) {  // iterates until the list is finished
        nelem++;
        tmp = tmp.getNext();
      }
    }
    return nelem;
  }

  public boolean isEmpty() {
    if (first == null) return true;
    else return false;
  }

  /*======================================================
    Devuelve la posición del primer elemento de la lista. Si
    no tiene ninguno devolver la posición FINAL.
    Precondición: La lista debe estar creada.
    ======================================================*/
  public Node primero() {  return first;  }

  /*======================================================
    Devuelve la posición siguiente a la última posición.
    Esta posición se usar para insertar elementos al final
    de la lista.
    Precondición: La lista debe estar creada
    ======================================================*/
  Node FinalLista(MySimpleLinkedList l) {
    Node p;
 
    p = l.first;
    while (p.getNext() != null) p = p.getNext();
    return (p);
  }

  /*======================================================
    Devuelve la posición del siguiente elemento en la lista a
    la posición p.
    Precondición: p debe ser una posición válida de la lista
    =====================================================*/
  public Node siguiente (Node p , MySimpleLinkedList l) {
    if (p != null && p.getNext() != null) 
      /*Comprobamos si tenemos una posición válida*/
      return(p.getNext());
    else return null;
  }

  public Node anterior(String o) {
    Node anterior, p;

    anterior = p = first;
    while (p.getNext() != null && o.compareTo((String) p.getInfo()) < 0) {
      anterior = p;
      p = p.getNext();
    }
    return anterior;
  }

  public void eliminar(Object dato) {
    Node pos = first, anterior = null;

    while(pos != null && !dato.equals(pos.getInfo())) {
      anterior = pos;
      pos = pos.getNext();
    }
    if (pos == null) return;   // No lo encontró
    if(pos == first) 
	  first = first.getNext();
    else 
      anterior.setNext(pos.getNext()); 
  }

  public void insertaOrden(String o) {
    Node nuevo = new Node(o, null);

    if (first == null) first = nuevo;
    else if (o.compareTo((String) first.getInfo()) < 0) {
           nuevo.setNext(first);
           first = nuevo;
         } else {
             Node anterior, p;

             anterior = p = first;
             while (p.getNext() != null && 
                    o.compareTo((String) p.getInfo()) > 0) {
               anterior = p;
               p = p.getNext();
             }
             if (o.compareTo((String) p.getInfo()) > 0 ) anterior = p;
             nuevo.setNext(anterior.getNext());
             anterior.setNext(nuevo);
           }
  }

  public void insertLast(Object o) {
    if (isEmpty()) insert(o);
    else {
      Node p;

      for(p = first; p.getNext() != null; p = p.getNext());
      p.setNext(new Node(o));
    }
  }
}

