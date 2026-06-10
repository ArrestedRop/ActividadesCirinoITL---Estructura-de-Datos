/*
Tecnológico Nacional de México
Instituto Tecnológico de León
Ingeniería en Sistemas Computacionales
Estructuras de datos
Lunes y miercoles 7:00 a 8:45
viernes 7:00 a 7:50
Alumno: Villagomez Magaña Maximo Javier
Tarea 30
Fecha: 20/4/2026
*/
package Entregables.Actividad_30;

import java.util.Scanner;

class Fibonacci {
  Scanner t = new Scanner(System.in); // las declaraciones no se incluyen
                                      // en el conteo de instrucciones
  void start() {                     
    System.out.println("despliega la serie de numeros de Fibonacci");  
    System.out.println("famosa por la pelicula Codigo D'Vinci\n");       
  }

  boolean isNum(String cad) {      // no forma parte del algoritmo
    try {                          // y solo se ejecuta en caso de una
      Integer.parseInt(cad);       // captura errónea
      return true;                 // no se incluye en el conteo de líneas
    } catch (NumberFormatException nfe) {
        System.out.println("Solo se admiten numero enteros\n");
        return false;
      }
  }

  int data() {
    String num = "";                                                    

    do {
      System.out.print("Deme el numero de términos que desea:");        // 1
      num = t.nextLine();                                               // 2
    } while (!isNum(num));                                              
    return Integer.parseInt(num);                                       
  }

  void fibonacci() {  // calculus y resultados
    int fnm1, fnm2, fn, n;                                              
                  
    fnm1 = fnm2 = fn = n = 0;                                           // 
    n = data();                                                         // 3  
    if (n <= 1)                                                         // 4
      System.out.print(n);                                              // 5
    else {
      System.out.print(fnm1);                                           // 6
      fnm1 = 1;                                                         // 7
      for (int i = 2; i <= n; i++) {                                    // n
        fn = fnm1 + fnm2;                                               // n-1 
        fnm2 = fnm1;                                                    // n-1
        fnm1 = fn;                                                      // n-1
        System.out.print(", "+fn);                                      // n-1 
      }
    }
  }         // ojo suman 5*n + 3

  public static void main(String args[]) {
    Fibonacci f = new Fibonacci();
    TimeElapsedMod t = new TimeElapsedMod();

    f.start();
    f.fibonacci();
    t.calcula();
    t.resulta();
  }
}

