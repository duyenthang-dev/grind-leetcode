package v1.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Runtime: 2ms - beat 80% java user
 * Memory: 44mb - beat 85%% java user
 */
public class ValidSudoku_36 {
    public boolean isValidSudoku(char[][] board) {
        var map = new HashMap<Character, ArrayList<Integer>>();
        for (int i =0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!map.containsKey(board[i][j])) {
                        var lst = new ArrayList<Integer>();
                        lst.add(i * 9 + j);
                        map.put(board[i][j], lst);
                    }
                    else {
                        var lst = map.get(board[i][j]);
                        for (int v: lst) {
                            int i1 = v / 9;
                            int j1 = v % 9;
                            if (i1 == i || j1 == j || isWithinSubMatrix(i, j, i1, j1))
                                return false;
                        }
                        lst.add(i * 9 + j);
                        map.put(board[i][j], lst);
                    }
                }
            }
        }
        return true;
    }

    private boolean isWithinSubMatrix(int i, int j, int i1, int j1) {
        return i / 3 == i1 /3 && j / 3 == j1 /3;
    }
    public static void main(String[] args) {
        var board = Arrays.stream(new String[][]{
                    {"8", "3", ".", ".", "7", ".", ".", ".", "."}
                ,   {"6", ".", ".", "1", "9", "5", ".", ".", "."}
                ,   {".", "9", "8", ".", ".", ".", ".", "6", "."}
                ,   {"8", ".", ".", ".", "6", ".", ".", ".", "3"}
                ,   {"4", ".", ".", "8", ".", "3", ".", ".", "1"}
                ,   {"7", ".", ".", ".", "2", ".", ".", ".", "6"}
                ,   {".", "6", ".", ".", ".", ".", "2", "8", "."}
                ,   {".", ".", ".", "4", "1", "9", ".", ".", "5"}
                ,   {".", ".", ".", ".", "8", ".", ".", "7", "9"}
        })
                .map(row -> Arrays.stream(row)
                        .mapToInt(e -> Character.valueOf(e.charAt(0)))
                        .toArray())
                .map(row -> String.valueOf(row).toCharArray())
                .toArray(char[][]::new);

        System.out.println(new ValidSudoku_36().isValidSudoku(board));
    }
}
