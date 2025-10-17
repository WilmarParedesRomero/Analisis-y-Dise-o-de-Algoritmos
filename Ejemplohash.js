import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TablaHash{
    public static void main(String[] args) {
        // Crear una tabla hash 
        Map<Integer, String> tablaHash = new HashMap<>();

        // Agregar algunos estudiantes
        tablaHash.put(101, "Ana");
        tablaHash.put(102, "Luis");
        tablaHash.put(103, "María");
        tablaHash.put(104, "Carlos");

        // Mostrar todos los elementos
        System.out.println("Lista de estudiantes:");
        for (Map.Entry<Integer, String> entry : tablaHash.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " -> Nombre: " + entry.getValue());
        }

        // Buscar estudiante por ID
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngrese el ID del estudiante a buscar: ");
        int idBuscar = sc.nextInt();

        if (tablaHash.containsKey(idBuscar)) {
            System.out.println("Estudiante encontrado: " + tablaHash.get(idBuscar));
        } else {
            System.out.println("No se encontró el estudiante con ID " + idBuscar);
        }

        // Eliminar un estudiante
        System.out.print("\nIngrese el ID del estudiante a eliminar: ");
        int idEliminar = sc.nextInt();
        if (tablaHash.containsKey(idEliminar)) {
            tablaHash.remove(idEliminar);
            System.out.println("Estudiante eliminado correctamente.");
        } else {
            System.out.println("No existe ese ID en la tabla.");
        }

        // Mostrar tabla actualizada
        System.out.println("\nTabla actualizada:");
        for (Map.Entry<Integer, String> entry : tablaHash.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " -> Nombre: " + entry.getValue());
        }

        sc.close();
    }
}
