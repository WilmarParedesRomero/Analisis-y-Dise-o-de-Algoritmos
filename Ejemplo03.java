// O(log n) - Búsqueda binaria
public class Ejemplo03 {
    public static boolean busquedaBinaria(int[] lista, int objetivo) {
        int izquierda = 0;
        int derecha = lista.length - 1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;

            if (lista[medio] == objetivo) {
                return true; // Encontrado
            } else if (lista[medio] < objetivo) {
                izquierda = medio + 1; // Buscar en la derecha
            } else {
                derecha = medio - 1; // Buscar en la izquierda
            }
        }
        return false; // No encontrado
    }

    public static void main(String[] args) {
        int[] numeros = {1, 2, 5, 7, 9}; // Lista ordenada
        System.out.println(busquedaBinaria(numeros, 7));
    }
}
