import java.util.HashMap;
import java.util.Scanner;

public class TransformacionDeClaves {  
    public static void main(String[] args) {
        HashMap<Integer, String> tablaHash = new HashMap<>();
        Scanner sc = new Scanner(System.in);
 
        // Insertar estudiantes 
        System.out.print("¿Cuántos estudiantes desea ingresar?: ");
        int cantidad = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        for (int i = 0; i < cantidad; i++) {
            System.out.println("\nEstudiante " + (i + 1) + ":");
            System.out.print("Código (entero): ");
            int codigo = sc.nextInt();
            sc.nextLine();
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            tablaHash.put(codigo, nombre);
        }

        // Buscar estudiante por código
        System.out.print("\nIngrese el código del estudiante a buscar: ");
        int clave = sc.nextInt();

        if (tablaHash.containsKey(clave)) {
            System.out.println("Estudiante encontrado: " + tablaHash.get(clave));
        } else {
            System.out.println("No se encontró ningún estudiante con ese código.");
        }

        sc.close();
    }
}
