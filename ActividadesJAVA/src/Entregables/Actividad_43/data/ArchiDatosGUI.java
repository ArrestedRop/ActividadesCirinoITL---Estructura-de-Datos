/* ArchiDatosGUI.java
   por Cirino Silva Tovar
   Diciembre 8 del 2008
   depurado 12 enero 2026
   Modificado el 10 de marzo del 2011 para que se comporte graficamente.
*/

package data;

import Entregables.Actividad_43.domain.*;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class ArchiDatosGUI {
  JOptionPane box = new JOptionPane();
  
  public static boolean isNum(String cad) {
    if (cad == null || cad.length() == 0)
       return false;
    try {  
      Double.parseDouble(cad); 
      return true; 
    } catch (NumberFormatException nfe) {
        //box.showMessageDialog(null, "Favor de teclear un numero.");
        return false;
      }   
  }

  public int datosIn(String file, MySimpleLinkedList A) { //entrada por archivo
    String name;
    double peso= 0, talla=0;
    IMC imc = null;
    int i = 0;
    Scanner in=null;

    try {
      File f = new File(file);

      if (f.exists() && f.canRead()) {
        in=new Scanner(f); // abre el archivo de datos
        while (in.hasNextLine()) {
          name = in.nextLine();
          peso = Double.parseDouble(in.nextLine());
          talla = Double.parseDouble(in.nextLine());
          imc = new IMC(name, peso, talla);
          A.insert(imc);
          i++;
        }
        box.showMessageDialog(null, "Se leyeron los datos de:"+file);
      } else box.showMessageDialog(null,"El archivo:"+file+" no existe");
    } catch (FileNotFoundException e) {
        System.out.println("Aparentemente no existe el archivo:"+file);
        e.printStackTrace(); 
        return 0;
      }
    finally {  if (in != null) in.close();  } // cierra el archivo de entrada
    return i;
  }

  public void datosOut(String file, MySimpleLinkedList A, int n) {    
    PrintStream out=null;
    Node temp = A.primero();
    IMC imct;

    try {
      out=new PrintStream(new FileOutputStream(file)); // abre el archivo de salida  
      while (temp != null) 
        if (temp.getInfo() instanceof IMC){
          imct = (IMC) temp.getInfo();
          out.println(imct.getNombre());        // lista se guarda en el archivo
          out.println(imct.getPeso());
          out.println(imct.getEstatura());
          temp = temp.getNext();
        }
      box.showMessageDialog(null,"Se escribieron los datos en:"+file);
    } catch (FileNotFoundException e) { 
        System.out.println("Error al dar salida en archivo:"+file);
        e.printStackTrace();
      } finally { out.close(); } // cierra el archivo de salida
  }

  public void listaFicheros(String path){
    File canal =new File(path);
    File []lista = canal.listFiles();
    String l="Archivos presentes en el subdirectorio de trabajo:"+path+"\n\n";

    for(int i = 0; i < lista.length;i++)
      l = l + lista[i]+"\n";
    box.showMessageDialog(null,l);
  }
}











