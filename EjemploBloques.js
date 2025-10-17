import java.util.Scanner;

public class BusquedaPorBloques {
    public static void main(String[] args) {
        int[] datos = {3, 5, 8, 12, 15, 18, 21, 25, 29, 33, 37, 40, 44, 47, 50};
        int bloque = 5; // tamaño del bloque
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el número a buscar: ");
        int objetivo = sc.nextInt();

        int n = datos.length;
        int inicioBloque = 0;
        int finBloque = bloque - 1;
        boolean encontrado = false;

        // Buscar el bloque donde podría estar el número
        while (finBloque < n && datos[finBloque] < objetivo) {
            inicioBloque += bloque;
            finBloque += bloque;
        }

        // Ajustar el último bloque si supera el tamaño
        if (finBloque >= n) finBloque = n - 1;

        // Búsqueda secuencial dentro del bloque encontrado
        for (int i = inicioBloque; i <= finBloque; i++) {
            if (datos[i] == objetivo) {
                System.out.println("Elemento encontrado en la posición: " + i);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Elemento no encontrado.");
        }

        sc.close();
    }
}
