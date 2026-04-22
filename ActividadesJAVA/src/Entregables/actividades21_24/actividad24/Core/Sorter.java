package Entregables.actividades21_24.actividad24.Core;

public class Sorter {
    public static Persona[] sort(Persona[] grupo) {
        int n = grupo.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < n; i++) {
                Persona temp = grupo[i];
                int j;

                for (j = i; j >= gap && grupo[j - gap].getNumero() > temp.getNumero(); j -= gap) {
                    grupo[j] = grupo[j - gap];
                }

                grupo[j] = temp;
            }
        }
        return grupo;
    }
}
