/**
 * @author [Thắng, Hà Duyên]
 * @email [duyenthang.dev@gmail.com]
 * @create date 2025-04-21 20:38:07
 * @modify date 2025-04-21 20:38:07
 * @desc [time taken: 25min]
 */
package lc_daily;

/*
 * notice the range of integer for long test case
 */
public class NumberOfArrays_2145 {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int min = 0;
        int max = 0;
        int sum = 0;
        for (int i = 0; i < differences.length; i++) {
            sum += differences[i];
            if (min > sum)
                min = sum;
            if (max < sum)
                max = sum;

        }
        int range = max - min;
        return Math.max(0, (upper - lower + 1) - range);
    }

    public static void main(String[] args) {

        var sol = new NumberOfArrays_2145();
        var differences = new int[] {-40 };
        int lower = -46;
        int upper = 53;
        System.out.println(sol.numberOfArrays(differences, lower, upper));
    }
}
