/*
Tecnológico Nacional de México
Instituto Tecnológico de León
Ingeniería en Sistemas Computacionales
Estructuras de datos
Lunes y miercoles 7:00 a 8:45
viernes 7:00 a 7:50
Alumno: Villagomez Magaña Maximo Javier
Tarea 34
Fecha: 6/5/2026
*/

package Entregables.Actividad_34;
import java.util.Scanner;

class Factorial {
  Scanner sc = new Scanner(System.in);
  int num;

  void inicio() {
    System.out.println("Calcula tabla de factoriales:");
  }
  
  boolean isNum(String cad) {
    try {
      Integer.parseInt(cad);
      return true;
    } catch(NumberFormatException nfe) {
        System.out.println("Solo se admiten numeros");
        return false;
      }
  }
 
  void captura() {
    String aux;
    
    do {
      System.out.print("De tamaño de la tabla:");
      aux = sc.nextLine();
    } while (!isNum(aux));
    num = Integer.parseInt(aux);      
  }

/*  double factorial(int n){
    double f=1.0;
    
    for(int i=1; i<=n; i++) f=f*i;
    return f;
  }
*/

  public long factorial( int n ) {
    if ( n <= 0 ) return 1; // base case
    else                   // general case
      return ( n * factorial ( n - 1 ) );
  }

  void resultado() {
    System.out.println("Tabla de factoriales:");
    System.out.println("Num.\t Factorial");
    System.out.println("_____________________");
    for (int i= 0; i <= num; i++)
      System.out.println(i+"\t"+factorial(i));
  }

  public static void main(String arg [] ){   
    Factorial cir=new Factorial();

    cir.inicio();
    cir.captura(); 
    cir.resultado();    
  }
}

