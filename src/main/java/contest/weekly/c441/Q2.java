package contest.weekly.c441;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class Q2 {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        var result = new ArrayList<Integer>();
        HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new TreeSet<>());
            }
            map.get(nums[i]).add(i);
        }

        for (int i = 0; i < queries.length; i++) {

            var set = map.get(nums[queries[i]]);

            if (set == null) {
                result.add(-1);
            } else if (set.size() == 1) {
                result.add(-1);
            } else {
                int min = Integer.MAX_VALUE;
                if (set.lower(queries[i]) != null) {
                    min = Math.min(min, queries[i] - set.lower(queries[i]));
                } else {
                    min = Math.min(min, nums.length - (set.last() - queries[i]));
                }
                if (set.higher(queries[i]) != null) {
                    min = Math.min(min, set.higher(queries[i]) - queries[i]);
                } else {
                    min = Math.min(min, nums.length - (queries[i] - set.first()));
                }
                if (min == Integer.MAX_VALUE)
                    result.add(-1);
                else
                    result.add(min);

            }
        }
        return result;
    }

    public static void main(String[] args) {
        var sol = new Q2();
        var nums = new int[] { 1, 2, 3, 4 };
        var queries = new int[] { 0, 1, 2, 3 };
        System.out.println(sol.solveQueries(nums, queries));
    }
}
