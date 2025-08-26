import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorEstudiantes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Pedir cantidad de estudiantes
        System.out.print("¿Cuántos estudiantes desea ingresar?: ");
        int cantidad = sc.nextInt();
        sc.nextLine(); // Consumimos el salto de línea que queda después de nextInt()

        // 2. Crear lista y pedir datos
        List<Estudiante> estudiantes = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\nEstudiante " + (i + 1) + ":");
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Nota: ");
            int nota = sc.nextInt();
            sc.nextLine(); // Consumimos el salto de línea
            estudiantes.add(new Estudiante(nombre, nota));
        }

        // 3. Preguntar criterio de ordenación
        System.out.println("\n¿Cómo desea ordenar la lista?");
        System.out.println("1. Por nota (ascendente)");
        System.out.println("2. Por nombre (A-Z)");
        System.out.print("Seleccione opción: ");
        int opcion = sc.nextInt();

        // 4. Ordenar según la elección
        if (opcion == 1) {
            ordenarPorInsercionNota(estudiantes);
            System.out.println("\nEstudiantes ordenados por nota:");
        } else if (opcion == 2) {
            ordenarPorInsercionNombre(estudiantes);
            System.out.println("\nEstudiantes ordenados por nombre:");
        } else {
            System.out.println("\nOpción no válida. Lista sin ordenar:");
        }

        // 5. Mostrar resultado
        for (Estudiante e : estudiantes) {
            System.out.println(e.getNombre() + " - Nota: " + e.getNota());
        }

        sc.close();
    }

    // Ordenar por nota usando inserción
    public static void ordenarPorInsercionNota(List<Estudiante> lista) {
        for (int i = 1; i < lista.size(); i++) {
            Estudiante actual = lista.get(i);
            int j = i - 1;
            while (j >= 0 && lista.get(j).getNota() > actual.getNota()) {
                lista.set(j + 1, lista.get(j));
                j--;
            }
            lista.set(j + 1, actual);
        }
    }

    // Ordenar por nombre usando inserción
    public static void ordenarPorInsercionNombre(List<Estudiante> lista) {
        for (int i = 1; i < lista.size(); i++) {
            Estudiante actual = lista.get(i);
            int j = i - 1;
            while (j >= 0 && lista.get(j).getNombre().compareToIgnoreCase(actual.getNombre()) > 0) {
                lista.set(j + 1, lista.get(j));
                j--;
            }
            lista.set(j + 1, actual);
        }
    }
}

// Clase Estudiante
class Estudiante {
    private String nombre;
    private int nota;

    public Estudiante(String nombre, int nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNota() {
        return nota;
    }
}
