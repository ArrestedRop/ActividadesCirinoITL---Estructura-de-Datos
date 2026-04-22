package Entregables.actividades21_24.actividad22;

import Entregables.actividades21_24.actividad24.Core.Persona;
import Entregables.actividades21_24.actividad24.Core.RegistroArchivo;
import Entregables.actividades21_24.actividad24.Core.RegistroManual;
import Entregables.actividad_26.Utilities.IOManager;
import Entregables.actividad_26.Utilities.Terminal;

public class Main {
    Persona[] grupo;
    Persona[] grupoO;
    RegistroManual regisMan = new RegistroManual();
    RegistroArchivo regisArc = new RegistroArchivo();

    public void goal(Terminal terminal) {
        String msg = "Codigo que busca poner a ";
        msg += "prueba las prestaciones del sorteo burbuja";
        terminal.imprimir(msg);
    }

    public void data(int selection) {
        switch(selection) {
            case 1 -> grupo = regisMan.dataManual();
            case 2 -> {
                String path = IOManager.fileSearcher();
                grupo = regisArc.dataArchivo(path);
            }
        }
    }

    public void procesos(int selection) {
        grupoO = bubbleSort.sort(grupo);
    }

    public void results(int selection, Terminal terminal) {
        String msg;
        switch(selection) {
            case 3 -> {
                for (int i = 0;i< grupoO.length;i++) {
                    msg = grupoO[i].getNumero() + "\\|" + grupoO[i].getNombre();
                    terminal.imprimir(msg);
                }
            }
            case 4 -> IOManager.fileWritter("resultado_ordenado.csv", grupoO);
        }
    }

    public int navegacion() {
        StringBuilder msg = new StringBuilder();
        msg.append("Seleccione una de las siguientes opciones\n ");
        msg.append("1.- Registro de datos manual\n");
        msg.append("2.- Registro de datos por archivo\n");
        msg.append("3.- Mostrar resultados ordenados en terminal\n");
        msg.append("4.- Pasar resultados ordenados a archivo");
        msg.append("5.- Salir");
        return IOManager.menuCreator(msg, 5);
    }

    public static void main(String[] args) {
        Main prueba = new Main();
        Terminal terminal = new Terminal("Terminal de impresion");
        int option;

        prueba.goal(terminal);
        do {
            option = prueba.navegacion();
            if(option != 5) {
                prueba.data(option);
                prueba.procesos(option);
                prueba.results(option, terminal);
            }
        }while(option != 5);
    }
}
