//Ejemplos de notacion Big O
// O(1) - Acceso a un elemento por índice
public class EjemploO1 {
    public static int obtenerPrimerElemento(int[] lista) {
        return lista[0]; // Siempre una sola operación
    } 

    public static void main(String[] args) {
        int[] numeros = {5, 2, 9, 1, 7};
        System.out.println(obtenerPrimerElemento(numeros));
    }
}
