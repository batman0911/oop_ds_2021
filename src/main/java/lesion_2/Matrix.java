package lesion_2;

public class Matrix {
    public static void main(String[] args) {

    }

    private static int sumRow(int[][] matrix, int row) {

        if (row > matrix.length) return -1;

        int sum = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            sum += matrix[row][i];
        }
        return sum;
    }
}
