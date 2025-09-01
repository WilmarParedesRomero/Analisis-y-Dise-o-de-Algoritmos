import java.io.*;
import java.util.*;

public class OrdenacionExternaSimple {

    // Método que divide el archivo en trozos, los ordena y los guarda en archivos temporales
    public static List<File> dividirYOrdenar(File archivoEntrada, int tamanoMaximo) throws IOException {
        List<File> archivosTemporales = new ArrayList<>();
        List<Integer> buffer = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoEntrada))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                buffer.add(Integer.parseInt(linea.trim()));

                if (buffer.size() >= tamanoMaximo) {
                    archivosTemporales.add(guardarOrdenado(buffer));
                    buffer.clear();
                }
            }
        }

        // Si quedó algo en el buffer al final
        if (!buffer.isEmpty()) {
            archivosTemporales.add(guardarOrdenado(buffer));
        }

        return archivosTemporales;
    }

    // Guarda una lista ordenada en un archivo temporal
    private static File guardarOrdenado(List<Integer> datos) throws IOException {
        Collections.sort(datos);
        File temp = File.createTempFile("chunk", ".txt");
        temp.deleteOnExit();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(temp))) {
            for (int num : datos) {
                bw.write(num + "\n");
            }
        }

        return temp;
    }

    // Fusión de los archivos temporales en un archivo de salida
    public static void fusionarArchivos(List<File> archivos, File archivoSalida) throws IOException {
        PriorityQueue<Elemento> cola = new PriorityQueue<>();
        List<BufferedReader> readers = new ArrayList<>();

        // Abrimos todos los archivos temporales
        for (File f : archivos) {
            BufferedReader br = new BufferedReader(new FileReader(f));
            readers.add(br);
            String linea = br.readLine();
            if (linea != null) {
                cola.add(new Elemento(Integer.parseInt(linea), br));
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida))) {
            while (!cola.isEmpty()) {
                Elemento e = cola.poll();
                bw.write(e.valor + "\n");

                String linea = e.origen.readLine();
                if (linea != null) {
                    cola.add(new Elemento(Integer.parseInt(linea), e.origen));
                }
            }
        }

        // Cerramos todo
        for (BufferedReader br : readers) {
            br.close();
        }
    }

    // Clase auxiliar para manejar la cola de prioridad
    private static class Elemento implements Comparable<Elemento> {
        int valor;
        BufferedReader origen;

        public Elemento(int valor, BufferedReader origen) {
            this.valor = valor;
            this.origen = origen;
        }

        @Override
        public int compareTo(Elemento otro) {
            return Integer.compare(this.valor, otro.valor);
        }
    }

    // Método principal: ejemplo
    public static void main(String[] args) throws IOException {
        File archivoEntrada = new File("numeros.txt");
        File archivoSalida = new File("numeros_ordenados.txt");

        // 1. Dividir y ordenar trozos
        List<File> archivosTemporales = dividirYOrdenar(archivoEntrada, 5);

        // 2. Fusionar trozos en archivo final
        fusionarArchivos(archivosTemporales, archivoSalida);

        System.out.println("Ordenación externa terminada. Resultado en: " + archivoSalida.getAbsolutePath());
    }
}
