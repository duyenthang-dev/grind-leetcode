package contest.weekly.c443;

import java.util.Arrays;

public class Q1 {
    public int[] minCosts(int[] cost) {
        var result = new int[cost.length];
        int minSofar = Integer.MAX_VALUE;
        for (int i =0; i < cost.length; i++) {
            if (cost[i] < minSofar) {
                minSofar = cost[i];
            }
            result[i] = minSofar;
        }
        return result;
    }
    public static void main(String[] args) {
        var sol = new Q1();
        var cost = new int[] {1,2,4,6,7};
        var res = sol.minCosts(cost);
        for (int i: res) {
            System.out.printf("%d \t", i);
        }
    }
}
