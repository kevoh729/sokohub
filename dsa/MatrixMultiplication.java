public class MatrixMultiplication {
    
    public static int[][] multiply(int[][] A, int[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;
        
        // Check if multiplication is possible
        if (colsA != rowsB) {
            System.out.println("Error: Incompatible dimensions");
            return null;
        }
        
        // Create result matrix
        int[][] result = new int[rowsA][colsB];
        
        // Triple nested loop multiplication
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        
        return result;
    }
    
    // Helper method to print matrix
    public static void printMatrix(int[][] matrix) {
        if (matrix == null) return;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    // Test the algorithm
    public static void main(String[] args) {
        // Example: 2x3 matrix A * 3x2 matrix B = 2x2 result
        int[][] A = {
            {1, 2, 3},
            {4, 5, 6}
        };
        
        int[][] B = {
            {7, 8},
            {9, 10},
            {11, 12}
        };
        
        System.out.println("Matrix A:");
        printMatrix(A);
        
        System.out.println("\nMatrix B:");
        printMatrix(B);
        
        int[][] result = multiply(A, B);
        
        System.out.println("\nResult (A * B):");
        printMatrix(result);
        
        // Expected output:
        // [1*7 + 2*9 + 3*11, 1*8 + 2*10 + 3*12] = [58, 64]
        // [4*7 + 5*9 + 6*11, 4*8 + 5*10 + 6*12] = [139, 154]
    }
}