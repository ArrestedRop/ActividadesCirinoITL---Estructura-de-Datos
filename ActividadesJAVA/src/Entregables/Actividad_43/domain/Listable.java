package Entregables.Actividad_43.domain;

interface Listable {
  public void vaciar();
  public boolean isEmpty();
  public boolean contiene(Object elem);
  public int tamaño();
  public void insert(Object elem);  //Inserta al inicio de la lista
  public void insertLast(Object elem);
  public void insertaOrden(String o);
  public Node buscar(Object o);
  public void eliminar(Object elem);   //Borra el primer nodo con valor elem
  public Node primero();
  public Node anterior(String o);
  public Node siguiente(Node p , MySimpleLinkedList l);
  public void sustituir(Object orig, Object nuevo);
}
