/*IMC.java
es la estructura de datos para el indice de masa corporal
codificado el 8 de septiembre 2015
por :_______
*/

package Entregables.Actividad_43.domain;

public class IMC {
  private String nombre;
  private double peso, estatura;

  public IMC() {}

  public IMC(String n, double p, double e) {
    setNombre(n);
    setPeso(p);
    setEstatura(e);
  }

  public boolean setNombre(String n) {
    if (n.length()!=0) {  // validacion ingenua
      nombre = n;
      return true;
    } else return false;
  }

  public boolean setPeso(double p){  // ojo no se valida el peso en gramos
    if (p > 0 && p < 200) {
       peso = p;
       return true;
    } else return false;
  }

  public boolean setEstatura(double e){
    if (e > 3) e = e / 100;
    if (e > 0 && e < 2.4) {
       estatura = e;
       return true;
    } else return false;
  }
  
  public String getNombre() {  return nombre;  }  
  public double getPeso() {  return peso;  }
  public double getEstatura() {  return estatura;  }

  public String toString() {
    return nombre + " " +estatura+ " "+ peso;
  }
}

