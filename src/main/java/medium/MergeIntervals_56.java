package medium;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals_56 {
    public int[][] merge(int[][] intervals) {
        // sort by starting time
        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][0] > intervals[j][0]) {
                    var temp = intervals[j];
                    intervals[j] = intervals[i];
                    intervals[i] = temp;
                }
            }
        }

        //
        var res = new ArrayList<int[]>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            var preInterval = res.get(res.size() - 1);
            var curr = intervals[i];
            // overlapsed
            if (preInterval[1] >= intervals[i][0]) {
                var newEnding = new int[]{preInterval[0], Math.max(preInterval[1], curr[1])};
                res.remove(res.size() - 1);
                res.add(newEnding);
            }
            else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
//        var intervals = new int[][]{
//                {1, 3},
//                {2, 6},
//                {8, 10},
//                {15, 18}
//        };

//        var intervals = new int[][]{
//                {1, 4},
//                {5, 6},
//        };
        var intervals = new int[][]{
                {1, 4},
                {0, 2},
                {3, 5},
        };

//        var intervals = new int[][]{
//                {1, 4},
//                {1, 4}
//        };
//        var intervals = new int[][]{{2,3},{5,5},{2,2},{3,4},{3,4}};

        System.out.println(Arrays.deepToString(new MergeIntervals_56().merge(intervals)));
    }
}
