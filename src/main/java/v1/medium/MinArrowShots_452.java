package v1.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class MinArrowShots_452 {
    public int findMinArrowShots(int[][] points) {
        var list = Arrays.stream(points).sorted(Comparator.comparingInt(o -> o[1])).collect(Collectors.toCollection(ArrayList::new));

        int count = 1;
        int i = 1;
        var curr = list.get(0);
        for (; i < list.size(); ) {
            var next = list.get(i);
            if (curr[1] >= next[0]) {
                i++;

            } else {
                count++;
                curr = list.get(i);
                i++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
//        var points = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
//        var points = new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}};
//        var points = new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}};
//        var points = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        var points = new int[][]{{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        System.out.println(new MinArrowShots_452().findMinArrowShots(points));
    }
}
