import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ListaInvertida {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, ArrayList<String>> listaInvertida = new HashMap<>();

        System.out.print("¿Cuántos estudiantes desea ingresar?: ");
        int cantidad = sc.nextInt();
        sc.nextLine();

        // Ingreso de estudiantes y cursos
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\nEstudiante " + (i + 1) + ":");
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("¿Cuántos cursos lleva este estudiante?: ");
            int numCursos = sc.nextInt();
            sc.nextLine();

            for (int j = 0; j < numCursos; j++) {
                System.out.print("Curso " + (j + 1) + ": ");
                String curso = sc.nextLine();

                // Agregar el estudiante a la lista de ese curso
                listaInvertida.putIfAbsent(curso, new ArrayList<>());
                listaInvertida.get(curso).add(nombre);
            }
        }

        // Mostrar toda la lista invertida
        System.out.println("\n=== LISTA INVERTIDA (Curso -> Estudiantes) ===");
        for (Map.Entry<String, ArrayList<String>> entrada : listaInvertida.entrySet()) {
            System.out.println(entrada.getKey() + " -> " + entrada.getValue());
        }

        // Búsqueda: quiénes llevan cierto curso
        System.out.print("\nIngrese un curso para buscar estudiantes: ");
        String cursoBuscar = sc.nextLine();

        if (listaInvertida.containsKey(cursoBuscar)) {
            System.out.println("Estudiantes que llevan " + cursoBuscar + ": " + listaInvertida.get(cursoBuscar));
        } else {
            System.out.println("No se encontró ningún estudiante que lleve ese curso.");
        }

        sc.close();
    }
}
