import java.util.ArrayList;
import java.util.List;

public class GestorEstudiantes {
    public static void main(String[] args) {
        // 1. Creamos una lista de estudiantes
        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("Ana", 15));
        estudiantes.add(new Estudiante("Luis", 12));
        estudiantes.add(new Estudiante("María", 18));
        estudiantes.add(new Estudiante("Carlos", 10));

        // 2. Ordenamos la lista por nota usando inserción
        ordenarPorInsercion(estudiantes);

        // 3. Mostramos la lista ordenada
        System.out.println("Estudiantes ordenados por nota:");
        for (Estudiante e : estudiantes) {
            System.out.println(e.getNombre() + " - Nota: " + e.getNota());
        }
    }

    // Método para ordenar por inserción
    public static void ordenarPorInsercion(List<Estudiante> lista) {
        for (int i = 1; i < lista.size(); i++) {
            Estudiante actual = lista.get(i);
            int j = i - 1;

            // Mientras la posición anterior tenga una nota mayor, movemos el elemento
            while (j >= 0 && lista.get(j).getNota() > actual.getNota()) {
                lista.set(j + 1, lista.get(j));
                j--;
            }

            // Insertamos el elemento actual en la posición correcta
            lista.set(j + 1, actual);
        }
    }
}

// Clase que representa un estudiante
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
