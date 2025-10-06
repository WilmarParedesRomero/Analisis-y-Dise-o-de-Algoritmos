import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
         
public class GestorEstudiantes {
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
      
        // 1. Pedir cantidad de estudiantes
        System.out.print("¿Cuántos estudiantes desea ingresar?: ");
        int cantidad = sc.nextInt();
        sc.nextLine(); // Consumimos el salto de línea que queda

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

        // 3. Preguntar criterio de ordenación
        System.out.println("\n¿Cómo desea ordenar la lista?");
        System.out.println("1. Por nota (ascendente)");
        System.out.println("2. Por nota (descendente)");
        System.out.println("3. Por nombre (A-Z)");
        System.out.println("4. Por nombre (Z-A)");
        System.out.print("Seleccione opción: ");
        int opcion = sc.nextInt();

        // 4. Ordenar según la elección
        switch (opcion) {
            case 1:
                ordenarPorInsercionNotaAsc(estudiantes);
                System.out.println("\nEstudiantes ordenados por nota (ascendente):");
                break;
            case 2:
                ordenarPorInsercionNotaDesc(estudiantes);
                System.out.println("\nEstudiantes ordenados por nota (descendente):");
                break;
            case 3:
                ordenarPorInsercionNombreAsc(estudiantes);
                System.out.println("\nEstudiantes ordenados por nombre (A-Z):");
                break;
            case 4:
                ordenarPorInsercionNombreDesc(estudiantes);
                System.out.println("\nEstudiantes ordenados por nombre (Z-A):");
                break;
            default:
                System.out.println("\nOpción no válida. Lista sin ordenar:");
        }

        // 5. Mostrar resultado final
        for (Estudiante e : estudiantes) {
            System.out.println(e.getNombre() + " - Nota: " + e.getNota());
        }

        sc.close();
    }

    // Ordenación por nota ascendente (menor a mayor)
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

    // Ordenación por nota descendente (mayor a menor)
    public static void ordenarPorInsercionNotaDesc(List<Estudiante> lista) {
        for (int i = 1; i < lista.size(); i++) {
            Estudiante actual = lista.get(i);
            int j = i - 1;
            while (j >= 0 && lista.get(j).getNota() < actual.getNota()) {
                lista.set(j + 1, lista.get(j));
                j--;
            }
            lista.set(j + 1, actual);
        }
    }

    // Ordenación por nombre ascendente (A-Z)
    public static void ordenarPorInsercionNombreAsc(List<Estudiante> lista) {
        for (int i = 1; i < lista.size(); i++) {
            Estudiante actual = lista.get(i);
            int j = i - 1;
            while (j >= 0 && lista.get(j).getNombre()
                    .compareToIgnoreCase(actual.getNombre()) > 0) {
                lista.set(j + 1, lista.get(j));
                j--;
            }
            lista.set(j + 1, actual);
        }
    }

    // Ordenación por nombre descendente (Z-A)
    public static void ordenarPorInsercionNombreDesc(List<Estudiante> lista) {
        for (int i = 1; i < lista.size(); i++) {
            Estudiante actual = lista.get(i);
            int j = i - 1;
            while (j >= 0 && lista.get(j).getNombre()
                    .compareToIgnoreCase(actual.getNombre()) < 0) {
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

 // Guardar en archivo .txt
    public static void guardarEnArchivo(ArrayList<Estudiante> lista) {
        try (FileWriter writer = new FileWriter("estudiantes.txt")) {
            for (Estudiante e : lista) {
                writer.write(e.nombre + "," + e.edad + "," + e.nota + "\n");
            }
            System.out.println("Datos guardados en estudiantes.txt");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

