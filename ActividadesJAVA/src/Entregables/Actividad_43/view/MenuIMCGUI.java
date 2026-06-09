/* MenuIMCGUI.java 
   clase que controla la aplicacion lista IMC grafico con persistencia
   Para ilustrar una aplicación de tres capas utiliza swing, 
   el 7 de noviembre del 2019
   por cirino Silva Tovar
   capa del usuario que implementa la navegavilidad, el control de eventos
   y la vista de la aplicacion. ojo vista y controlador
*/

package Entregables.Actividad_43.view;

import Entregables.Actividad_43.domain.*;
import Entregables.Actividad_43.data.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

class MenuIMCGUI extends Frame implements ActionListener { // vista y oyente
  private JOptionPane messageBox;                          // de eventos
  IMCGUI imcpg = new IMCGUI();     // modelo del negocio
  ArchiDatosGUI adg = new ArchiDatosGUI();      // persistencia
  int n;

  public MenuIMCGUI()    {  // constructor por defecto
    createMenu();
    setTitle("Lista ligada de IMC");
    addWindowListener(new CloseHandler());  // registra el oyente en el frame
    setLocation(200,200);                   // para el cierre de la ventana
    setSize(300,200);
  }

  public void actionPerformed(ActionEvent event)    {  //event handler
    String menuName;                                  // action

    menuName = event.getActionCommand();       // tipo de accion
    switch (menuName) {
      case "Nuevo":      newProm();   break;
      case "Abrir...":   open();      break;        
      case "Guardar" :   save();      break;       
      case "Salir"   :   quit();      break;       
      case "Captura" :   edit();      break;       
      case "Resultados": resultado(); break;        
      case "Ayuda":      ayuda();
    }        
  }

  private void createMenu() {
    MenuItem    item;
    Menu        menu;
    MenuBar     menuBar;
    String [] bar  = {"Archivo","Entradas","Mostrar"};
    String [][]opt = {{"Nuevo","Abrir...","Guardar","Salir"},
                      {"Captura"},
                      {"Resultados","Ayuda"}};

    menuBar = new MenuBar();           //create menubar first
    for (int i = 0 ; i < bar.length; i++) {
      menu = new Menu(bar[i]);         //Show Menu
      menuBar.add(menu);               // agrega menu a la barra
      for (int j = 0; j < opt[i].length; j++ ) {
        item = new MenuItem(opt[i][j]);      
        item.addActionListener( this );// registra oyente de accion
        menu.add( item );              // agrega elemento al menu
      }
    }        
    setMenuBar(menuBar); //set menubar AFTER all menus are added to it
  }

  private void resultado( )    {
    imcpg.calculos();
    imcpg.resultados();
  }

  private void ayuda(){
    String l= "";
    l= l +"Cuando se solicite el nombre ";
    l= l +"de un archivo, usted puede dar <enter> ";
    l= l +"para visualizar el contenido ";
    l= l +"del subdirectorio de trabajo actual ";   
    messageBox.showMessageDialog(null,l);
  }

  private void edit(){   n = imcpg.datos();   }

  private void newProm(){
    String l= "";

    n = 0;
    l = l+ "Se ha limpiado la lista";
    l = l+ "con cero datos, ahora hay disponibles";
    messageBox.showMessageDialog(null,l);
  }

  private void open()    {
    String arch="";

    arch = messageBox.showInputDialog("Deme nombre del archivo:");
    if (arch.equals("")||arch == null) 
      adg.listaFicheros(".");
    else n = adg.datosIn(arch, imcpg.listIMC);    
  }

  private void quit() {   System.exit(0);   }

  private void save() {
    String arch="";

    arch = messageBox.showInputDialog("Deme nombre del archivo:");
    if (arch.equals("")||arch == null) 
      adg.listaFicheros(".");
    else adg.datosOut(arch, imcpg.listIMC, n);
  }

  public static void main (String arg[]){
    MenuIMCGUI mimcg = new MenuIMCGUI();

    mimcg.imcpg.inicio();      // la navegabilidad se hace en el hilo de 
    mimcg.setVisible(true);  // despacho de eventos
  }
  
  private class CloseHandler extends WindowAdapter {
    public void windowClosing(WindowEvent e) {  System.exit(0);  }
  }
}

