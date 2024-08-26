package medium;

/**
 * 90 deg rotate:
 * -> j1 = colLen - i0
 * -> i1 = rowLen - j0
 * Sol2:
 * chuyển vị ma trận sau đó
 */
public class RotateImage_48 {

    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                //swap
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                //swap
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]
                {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new RotateImage_48().rotate(matrix);
        for (var i = 0; i < matrix.length; i++) {
            for (var j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }
}
