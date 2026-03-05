package Approach_MasProfesional.actividad_01a09.Printers;

import Entregables.actividad_01a09.Persona;

import javax.swing.*;

public class ImpresionIndividual {

    //Clase enfocada en solo imprimir individual,
    //intentando imitar los principios SOLID

    public void outs(int pos, int compara, Persona[] grupo, String nombre) {
        String num_con = grupo[pos].getNum_con();
        String fecha_nac = grupo[pos].getFecha_nac();
        double peso =  grupo[pos].getPeso();
        double talla = grupo[pos].getTalla();

        String impresion = "El nombre solicitado: " + nombre +
                           "\nEsta en la posicion: " + pos +
                           "\nSu numero de control es: " + num_con +
                           "\nNacio el: " + fecha_nac +
                           "\nSu peso es: "+ peso +
                           "\nSu talla es: "+ talla +
                           "\nSe realizaron "+ compara
                + " preguntas para la busqueda";

        if (pos!=-1) {
            JOptionPane.showMessageDialog(null,impresion,
                    "Entregables.tarea_01.Persona Encontrada", JOptionPane.OK_OPTION);
        }
        else {
            JOptionPane.showMessageDialog(null,"Entregables.tarea_01.Persona no encontrada",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }
}
