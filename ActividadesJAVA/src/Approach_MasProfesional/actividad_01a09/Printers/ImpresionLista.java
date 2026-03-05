package Approach_MasProfesional.actividad_01a09.Printers;

import Approach_MasProfesional.actividad_01a09.Extras.Terminal;
import Entregables.actividad_01a09.Persona;

public class ImpresionLista {

    public void list(Persona[] grupo, Terminal terminal) {
        for(int i = 0; i < grupo.length; i++){
            String nom = grupo[i].getNombre();
            String fecha_nac = grupo[i].getFecha_nac();
            String num_con = grupo[i].getNum_con();
            double peso = grupo[i].getPeso();
            double talla = grupo[i].getTalla();

            String Impresion = (i+1) + ".- | " + nom +
                                         " | " + fecha_nac +
                                         " | " + num_con +
                                         " | " + peso +
                                         " | " + talla;
            terminal.imprimir(Impresion);
        }
    }
}
