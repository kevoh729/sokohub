public class MatrixMultiplier {

    
    public static int[][] multiply(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;

        
        if (colsA != rowsB) {
            throw new IllegalArgumentException("Matrix dimensions mismatch: Cols of A must equal Rows of B.");
        }

        
        int[][] result = new int[rowsA][colsB];

        
        for (int i = 0; i < rowsA; i++) { /
            for (int j = 0; j < colsB; j++) { 
                for (int k = 0; k < colsA; k++) { 
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return result;
    }

  
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] A = {
            {1, 2, 3},
            {4, 5, 6}
        };

        int[][] B = {
            {7, 8},
            {9, 10},
            {11, 12}
        };

        try {
            int[][] result = multiply(A, B);
            System.out.println("Resulting Matrix:");
            printMatrix(result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}