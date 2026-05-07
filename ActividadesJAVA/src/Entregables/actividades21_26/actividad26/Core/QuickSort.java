package Entregables.actividades21_26.actividad26.Core;

public class QuickSort {
        public static Persona[] sort(Persona[] arrOriginal) {
            if (arrOriginal == null) return null;
            Persona[] arrClonado = arrOriginal.clone();
            ejecutarQuickSort(arrClonado, 0, arrClonado.length - 1);
            return arrClonado;
        }

        private static void ejecutarQuickSort(Persona[] arr, int low, int high) {
            if (low < high) {
                int pi = particionar(arr, low, high);
                ejecutarQuickSort(arr, low, pi - 1);
                ejecutarQuickSort(arr, pi + 1, high);
            }
        }

        private static int particionar(Persona[] arr, int low, int high) {
            int pivot = arr[high].getNumero();
            int i = (low - 1);

            for (int j = low; j < high; j++) {
                if (arr[j].getNumero() <= pivot) {
                    i++;
                    Persona temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

            Persona temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;

            return i + 1;
        }
}