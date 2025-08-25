import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorEstudiantes {
    public static void main(String[] args) {
        // 1. Creamos lista de estudiantes
        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("Ana", 15));
        estudiantes.add(new Estudiante("Luis", 12));
        estudiantes.add(new Estudiante("María", 18));
        estudiantes.add(new Estudiante("Carlos", 10));

        // 2. Preguntamos al usuario el criterio de ordenación
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cómo desea ordenar la lista?");
        System.out.println("1. Por nota (ascendente)");
        System.out.println("2. Por nombre (A-Z)");
        System.out.print("Seleccione opción: ");
        int opcion = sc.nextInt();

        // 3. Ejecutamos la ordenación según lo elegido
        if (opcion == 1) {
            ordenarPorInsercionNota(estudiantes);
            System.out.println("\nEstudiantes ordenados por nota:");
        } else if (opcion == 2) {
            ordenarPorInsercionNombre(estudiantes);
            System.out.println("\nEstudiantes ordenados por nombre:");
        } else {
            System.out.println("Opción no válida. Mostrando lista sin ordenar:");
        }

        // 4. Mostramos el resultado
        for (Estudiante e : estudiantes) {
            System.out.println(e.getNombre() + " - Nota: " + e.getNota());
        }

        sc.close();
    }

    // Ordenación por nota usando inserción
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

    // Ordenación por nombre usando inserción
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

