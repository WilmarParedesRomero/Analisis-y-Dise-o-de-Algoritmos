// O(n) - Búsqueda secuencial
public class Ejemplo02 {
    public static boolean buscarNumero(int[] lista, int objetivo) {
        for (int num : lista) { // Recorre todos los elementos
            if (num == objetivo) {
                return true; // Lo encontró
            }
        }
        return false; // No lo encontró
    }

    public static void main(String[] args) {
        int[] numeros = {5, 2, 9, 1, 7};
        System.out.println(buscarNumero(numeros, 9));
    }
}
