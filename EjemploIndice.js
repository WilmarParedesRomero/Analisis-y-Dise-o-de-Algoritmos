import java.util.Scanner;
 
public class BusquedaMedianteIndices {
    public static void main(String[] args) {
        int[] datos = {3, 5, 8, 12, 15, 18, 21, 25, 29, 33, 37, 40, 44, 47, 50};
        int[] indices = {0, 5, 10}; // apunta al inicio de cada grupo (0, 5, 10)
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el número a buscar: ");
        int objetivo = sc.nextInt();

        int grupo = -1;

        // Determinar en qué grupo buscar
        for (int i = 0; i < indices.length; i++) {
            int pos = indices[i];
            if (i == indices.length - 1 || datos[indices[i + 1] - 1] >= objetivo) {
                grupo = i;
                break;
            }
        }

        if (grupo == -1) {
            System.out.println("Elemento no encontrado.");
            return;
        }

        // Búsqueda secuencial dentro del grupo determinado
        int inicio = indices[grupo];
        int fin = (grupo == indices.length - 1) ? datos.length - 1 : indices[grupo + 1] - 1;

        boolean encontrado = false;
        for (int i = inicio; i <= fin; i++) {
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

