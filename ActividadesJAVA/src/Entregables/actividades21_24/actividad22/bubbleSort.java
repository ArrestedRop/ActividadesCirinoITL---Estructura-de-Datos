package Entregables.actividades21_24.actividad22;

import Entregables.actividades21_24.actividad24.Core.Persona;

public class bubbleSort {

    public static Persona[] sort(Persona[] grupo) {
        int n = grupo.length;
        int counter = 0;
        Persona temp;


        for(int i = 0; i<n; i++) {
            for (int j = 0;j<n-1;j++) {
                if (grupo[j].getNumero() > grupo[j].getNumero()) {
                    temp = grupo[j];
                    grupo[j] = grupo[j+1];
                    grupo[j+1] = temp;
                    counter++;
                }
            }
        }
        return grupo;
    };
}
