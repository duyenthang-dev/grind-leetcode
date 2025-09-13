package v1.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertInterval_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {

       var listInterval = new ArrayList<int[]>();
       boolean isAdd = false;
       for (var interval : intervals) {
           if (!isAdd && newInterval[0] <= interval[0]) {
               listInterval.add(newInterval);
               isAdd = true;
           }

           listInterval.add(interval);

       }

       if (listInterval.isEmpty())
           listInterval.add(newInterval);

       if (!isAdd)
           listInterval.add(newInterval);

        var res = new ArrayList<int[]>();
        res.add(listInterval.get(0));
        for (int i = 1; i < listInterval.size(); i++) {
            var preInterval = res.get(res.size() - 1);
            var curr = listInterval.get(i);
            // overlapsed
            if (preInterval[1] >= curr[0]) {
                var newEnding = new int[]{preInterval[0], Math.max(preInterval[1], curr[1])};
                res.remove(res.size() - 1);
                res.add(newEnding);
            }
            else {
                res.add(curr);
            }
        }
        return res.toArray(new int[res.size()][]);

    }

    public static void main(String[] args) {
        var intervals = new int[][]{
                {1, 5}, {3, 7}
        };

        var newInterval = new int[]{10, 16};


//        var intervals = new int[][]{
//                {1,2},{3,5},{6,7},{8,10},{12,16}
//        };
//
//        var newInterval = new int[]{4, 8};
        System.out.println(Arrays.deepToString(new InsertInterval_57().insert(intervals, newInterval)));
    }
}
