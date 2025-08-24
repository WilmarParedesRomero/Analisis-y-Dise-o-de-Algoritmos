// O(n²) - Bubble Sort
import java.util.Arrays;

public class Ejemplo05 {
    public static int[] bubbleSort(int[] lista) {
        int n = lista.length;
        for (int i = 0; i < n; i++) { // n pasadas
            for (int j = 0; j < n - i - 1; j++) { // Comparaciones en cada pasada
                if (lista[j] > lista[j + 1]) {
                    // Intercambiar
                    int temp = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = temp;
                }
            }
        }
        return lista;
    }

    public static void main(String[] args) {
        int[] numeros = {5, 2, 9, 1, 7};
        System.out.println(Arrays.toString(bubbleSort(numeros)));
    }
}
