package medium;

import java.util.Arrays;

public class GasStation_134 {
    /**
     * At every position remaining = gas[i] - cost[i] <br />
     * totalRemaining is sum of remaining of all postion <br />
     * Start at gas[0] = 5 <br />
     * 5    1   2   3   4 <br />
     * 4    4   1   5   1 	<br />
     * 1   -3   1  -2   3 -> total = -1 + -3 + 1 + -2 + 3 <br />
     * Start at gas[1] = 1, let move the orignial position of all elm to the left 1 unit. It looks like <br />
     * 1   2   3   4   5 <br />
     * 4   1   5   1 	4 <br />
     * -3   1  -2   3   1 -> total =  -3 + 1 + -2 + 3 + -1 <br />
     * Start at gas[2] = 2, let move the orignial position of all elm to the left 2 unit. It looks like <br />
     * 2   3   4   5    1 <br />
     * 1   5   1   4    4 <br />
     * 1  -2   3   1   -3 -> total =  1 + -2 + 3 + 1 -3 <br />
     * -> So you relize that, the total remaining alway be the same. whatever the position you start <br />
     * You can complete circut if and only if you can start at the begining of array and go through the end <br />
     * -> the whole remaining (totalRemaining) >=0 and at every step, remaining must be >= 0 to move on
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalRemaining = 0;
        int remaining = 0;
        int start = 0;
        for (int i =0; i< gas.length; i++) {
            totalRemaining += gas[i] - cost[i];
            remaining += gas[i] - cost[i];
            if (remaining < 0) {
                start += 1;
                remaining = 0;
            }
        }
        return totalRemaining <0 ? -1: start;
    }
    public static void main(String[] args) {
        int[] gas = new int[] {4};
        int[] cost = new int[] {5};
        System.out.println(new GasStation_134().canCompleteCircuit(gas, cost));
    }
}
