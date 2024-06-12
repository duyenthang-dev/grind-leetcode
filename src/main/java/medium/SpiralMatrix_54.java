package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Runtime: 2ms - beat 80% java user
 * Memory: 44mb - beat 85%% java user
 */
public class SpiralMatrix_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int i =0; int j = 0;
        int minRow =0, maxRow = matrix.length;
        int minCol = 0, maxCol = matrix[0].length;
        var  res = new ArrayList<Integer>();
        int total = matrix.length * matrix[0].length;
        while (total > 0) {
            res.add(matrix[i][j]);
//            if
        }
        return null;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]
                {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(new SpiralMatrix_54().spiralOrder(matrix));
    }
}
