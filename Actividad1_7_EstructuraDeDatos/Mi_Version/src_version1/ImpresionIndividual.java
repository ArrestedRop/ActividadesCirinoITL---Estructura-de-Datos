import javax.swing.*;

public class ImpresionIndividual {

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
                    "Persona Encontrada", JOptionPane.OK_OPTION);
        }
        else {
            JOptionPane.showMessageDialog(null,"Persona no encontrada",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }
}
