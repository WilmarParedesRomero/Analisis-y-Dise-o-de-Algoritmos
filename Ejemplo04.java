// O(n log n) - Merge Sort
import java.util.Arrays;

public class Ejemplo04 {
    public static int[] mergeSort(int[] lista) {
        if (lista.length <= 1) {
            return lista; // Caso base
        }

        int medio = lista.length / 2;

        int[] izquierda = mergeSort(Arrays.copyOfRange(lista, 0, medio));
        int[] derecha = mergeSort(Arrays.copyOfRange(lista, medio, lista.length));

        return merge(izquierda, derecha);
    }

    private static int[] merge(int[] izq, int[] der) {
        int[] resultado = new int[izq.length + der.length];
        int i = 0, j = 0, k = 0;

        while (i < izq.length && j < der.length) {
            if (izq[i] < der[j]) {
                resultado[k++] = izq[i++];
            } else {
                resultado[k++] = der[j++];
            }
        }

        while (i < izq.length) resultado[k++] = izq[i++];
        while (j < der.length) resultado[k++] = der[j++];

        return resultado;
    }

    public static void main(String[] args) {
        int[] numeros = {5, 2, 9, 1, 7};
        System.out.println(Arrays.toString(mergeSort(numeros)));
    }
}
