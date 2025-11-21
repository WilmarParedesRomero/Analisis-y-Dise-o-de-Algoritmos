public class Sudoku4x4 {

    // Sudoku a resolver (0 significa casilla vacía)
    private static int[][] tablero = {
            {1, 0, 0, 4},
            {0, 0, 3, 0},
            {0, 3, 0, 0},
            {2, 0, 0, 1}
    };

    public static void main(String[] args) {
        System.out.println("Sudoku inicial:");
        imprimirTablero();

        if (resolverSudoku()) {
            System.out.println("\nSudoku resuelto:");
            imprimirTablero();
        } else {
            System.out.println("No tiene solución.");
        }
    }

    // ----- MÉTODO PRINCIPAL DE BACKTRACKING -----
    public static boolean resolverSudoku() {
        // Buscar una casilla vacía
        for (int fila = 0; fila < 4; fila++) {
            for (int col = 0; col < 4; col++) {
                if (tablero[fila][col] == 0) {

                    // Probar los números del 1 al 4
                    for (int num = 1; num <= 4; num++) {
                        if (esValido(fila, col, num)) {
                            tablero[fila][col] = num; // Tentativa

                            // Llamada recursiva
                            if (resolverSudoku())
                                return true;

                            tablero[fila][col] = 0; // BACKTRACK: volver atrás
                        }
                    }

                    return false; // No hay número válido
                }
            }
        }

        return true; // No hay casillas vacías → SOLUCIONADO
    }

    // ----- VALIDACIÓN -----
    public static boolean esValido(int fila, int col, int num) {

        // Validar fila
        for (int i = 0; i < 4; i++) {
            if (tablero[fila][i] == num)
                return false;
        }

        // Validar columna
        for (int i = 0; i < 4; i++) {
            if (tablero[i][col] == num)
                return false;
        }

        // Validar subcuadro 2x2
        int inicioFila = (fila / 2) * 2;
        int inicioCol = (col / 2) * 2;

        for (int i = inicioFila; i < inicioFila + 2; i++) {
            for (int j = inicioCol; j < inicioCol + 2; j++) {
                if (tablero[i][j] == num)
                    return false;
            }
        }

        return true;
    }

    // ----- IMPRIMIR TABLERO -----
    public static void imprimirTablero() {
        for (int[] fila : tablero) {
            for (int num : fila) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
