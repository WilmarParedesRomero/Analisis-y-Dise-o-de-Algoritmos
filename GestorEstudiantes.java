import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorEstudiantes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Pedir cantidad de estudiantes
        System.out.print("¿Cuántos estudiantes desea ingresar?: ");
        int cantidad = sc.nextInt();
        sc.nextLine();

        // 2. Crear lista y pedir datos
        List<Estudiante> estudiantes = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\nEstudiante " + (i + 1) + ":");
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Nota: ");
            int nota = sc.nextInt();
            sc.nextLine();
            estudiantes.add(new Estudiante(nombre, nota));
        }

        // 3. Mostrar menú de ordenación
        System.out.println("\n¿Cómo desea ordenar la lista?");
        System.out.println("1. Inserción por nota (ascendente)");
        System.out.println("2. Inserción por nombre (A-Z)");
        System.out.println("3. Shell Sort por nota");
        System.out.println("4. Quick Sort por nombre");
        System.out.println("5. Quick Sort por nota");
        System.out.print("Elija una opción: ");
        int opcion = sc.nextInt();

        // 4. Ejecutar según opción
        switch (opcion) {
            case 1:
                ordenarPorInsercionNotaAsc(estudiantes);
                break;
            case 2:
                ordenarPorInsercionNombreAsc(estudiantes);
                break;
            case 3:
                shellSortPorNota(estudiantes);
                break;
            case 4:
                quickSortPorNombre(estudiantes, 0, estudiantes.size() - 1);
                break;
            case 5:
                quickSortPorNota(estudiantes, 0, estudiantes.size() - 1);
                break;
            default:
                System.out.println("Opción no válida.");
        }

        // 5. Mostrar resultados
        System.out.println("\n=== Lista Ordenada ===");
        for (Estudiante e : estudiantes) {
            System.out.println(e.getNombre() + " - Nota: " + e.getNota());
        }

        sc.close();
    }

    // =======================================================
    //   MÉTODOS DE ORDENACIÓN 
    // =======================================================

    public static void ordenarPorInsercionNotaAsc(List<Estudiante> lista) {
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

    public static void ordenarPorInsercionNombreAsc(List<Estudiante> lista) {
        for (int i = 1; i < lista.size(); i++) {
            Estudiante actual = lista.get(i);
            int j = i - 1;
            while (j >= 0 &&
                lista.get(j).getNombre().compareToIgnoreCase(actual.getNombre()) > 0) {
                lista.set(j + 1, lista.get(j));
                j--;
            }
            lista.set(j + 1, actual);
        }
    }

    // =======================================================
    //                     SHELL SORT
    // =======================================================

    public static void shellSortPorNota(List<Estudiante> lista) {
        int n = lista.size();

        // Gap inicial = mitad
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Insertion sort pero saltando gaps
            for (int i = gap; i < n; i++) {
                Estudiante temp = lista.get(i);
                int j = i;

                while (j >= gap && lista.get(j - gap).getNota() > temp.getNota()) {
                    lista.set(j, lista.get(j - gap));
                    j -= gap;
                }
                lista.set(j, temp);
            }
        }
    }

    // =======================================================
    //                    QUICK SORT NOMBRE
    // =======================================================

    public static void quickSortPorNombre(List<Estudiante> lista, int inicio, int fin) {
        if (inicio < fin) {
            int pivote = particionNombre(lista, inicio, fin);
            quickSortPorNombre(lista, inicio, pivote - 1);
            quickSortPorNombre(lista, pivote + 1, fin);
        }
    }

    private static int particionNombre(List<Estudiante> lista, int inicio, int fin) {
        Estudiante pivote = lista.get(fin);
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (lista.get(j).getNombre().compareToIgnoreCase(pivote.getNombre()) <= 0) {
                i++;
                Estudiante temp = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, temp);
            }
        }

        Estudiante temp = lista.get(i + 1);
        lista.set(i + 1, lista.get(fin));
        lista.set(fin, temp);

        return i + 1;
    }

    // =======================================================
    //                    QUICK SORT NOTA
    // =======================================================

    public static void quickSortPorNota(List<Estudiante> lista, int inicio, int fin) {
        if (inicio < fin) {
            int pivote = particionNota(lista, inicio, fin);
            quickSortPorNota(lista, inicio, pivote - 1);
            quickSortPorNota(lista, pivote + 1, fin);
        }
    }

    private static int particionNota(List<Estudiante> lista, int inicio, int fin) {
        Estudiante pivote = lista.get(fin);
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (lista.get(j).getNota() <= pivote.getNota()) {
                i++;
                Estudiante temp = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, temp);
            }
        }

        Estudiante temp = lista.get(i + 1);
        lista.set(i + 1, lista.get(fin));
        lista.set(fin, temp);

        return i + 1;
    }
}

// =======================================================
//                  CLASE ESTUDIANTE
// =======================================================

class Estudiante {
    private String nombre;
    private int nota;

    public Estudiante(String nombre, int nota) {
        this.nombre = nombre;
        this.nota = nota;
    }
    public String getNombre() { return nombre; }
    public int getNota() { return nota; }
}
