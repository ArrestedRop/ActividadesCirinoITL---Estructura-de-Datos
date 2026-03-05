package Approach_MasProfesional.actividad_01a09.Searchers;

import Entregables.actividad_01a09.Persona;

public class BusquedaBinaria {

        private int compara = 0;

        public int binarySearch(String objetivo, Persona[] grupo, int cuenta) {
            this.compara = 0;
            int inicio = 0;
            int fin = cuenta - 1;

            while (inicio <= fin) {
                this.compara++;
                int mitad = inicio + (fin - inicio) / 2;
                String valorMitad = grupo[mitad].getNombre();

                int resultado = objetivo.compareToIgnoreCase(valorMitad);

                if (resultado == 0) {
                    return mitad; //
                }
                if (resultado > 0) {
                    inicio = mitad + 1;
                } else {
                    fin = mitad - 1;
                }
            }
            return -1;
        }

        public int getCompara() { return this.compara; }
    }