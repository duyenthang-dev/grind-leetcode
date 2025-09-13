package v1.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Runtime: 2ms - beat 80% java user
 * Memory: 44mb - beat 85%% java user
 */
public class SpiralMatrix_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int j0 = 0, i1 = matrix.length - 1, i0 = 0, j1 = matrix[0].length - 1;
        var res = new ArrayList<Integer>();
        int count = matrix.length * matrix[0].length;
        while (true) {
            var temp = spiralOrderRecur(matrix, j0, j1, i0, i1, count);
            res.addAll(temp);
            count -= temp.size();
            if (j1 != 0) {
                j0++;
                j1--;
            }
            i0++;
            if (i1 !=0) {
                i1--;
            }
            if (count <= 1) break;

        }
        if (count == 1)
            res.add(matrix[i0][j0]);
        return res;
    }

    public List<Integer> spiralOrderRecur(int[][] matrix, int j0, int j1, int i0, int i1, int remainingItems) {
        int i = i0, j = j0;
        var res = new ArrayList<Integer>();
        int rowOffset = 0;
        int colOffset = 0;
        res.add(matrix[i][j]);
        do  {
            if (remainingItems == res.size() || matrix[i].length == 1)
                break;

            if (i == i0 && j == j0 && j1 > j0) {
                rowOffset = 0;
                colOffset = 1;
            }

            else if (i == i0 && j == j1 && i1 > i0) {
                rowOffset = 1;
                colOffset = 0;
            }
            else if (i == i1 && j == j1) {
                rowOffset = 0;
                colOffset = -1;
            } else if (i == i1 && j == j0) {
                rowOffset = -1;
                colOffset = 0;
            }
            res.add(matrix[i + rowOffset][j + colOffset]);
            i += rowOffset;
            j += colOffset;
        }while (!(i == i0 + 1 && j == j0 && j0 != j1));
        return res;
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[][]
//                {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
//        int[][] matrix = new int[][]
//                {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = new int[][]
                {{1}, {5}};

//                int[][] matrix = new int[][]
//                {{2, 3, 4}, {5, 6,7}, {8, 9, 10}, {11, 12, 13}, {14, 15, 16}};
        System.out.println(new SpiralMatrix_54().spiralOrder(matrix));
    }
}
