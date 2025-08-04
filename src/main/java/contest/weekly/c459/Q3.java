package contest.weekly.c459;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Q3 {
    private Map<Long, Integer> depthCache = new HashMap<>();
    public int[] popcountDepth(long[] nums, long[][] queries) {
        var result = new ArrayList<Integer>();
        var temp = nums;
        for (int i = 0; i < queries.length; i++) {
           if (queries[i][0] == 1) {
               int l = (int)queries[i][1], r = (int)queries[i][2], k = (int)queries[i][3];
               int count = 0;
                
                for (int j = l; j <= r; j++) {
                    if (getPopcountDepth(temp[j]) == k) {
                        count++;
                    }
                }
                result.add(count);
           }else {
                int idx = (int)queries[i][1];
                long newValue = queries[i][2];
                temp[idx] = newValue;
           }
        }
        return result.stream().mapToInt(i -> i).toArray();
        
    }

    private int getPopcountDepth(long x) {
        if (depthCache.containsKey(x)) {
            return depthCache.get(x);
        }
        int depth = 0;
        long current = x;

        while (current != 1) {
            current = Long.bitCount(current);
            depth++;
        }
        
        depthCache.put(x, depth);
        return depth;

    }
    public static void main(String[] args) {

        // Input: nums = [3,5,6], queries = [[1,0,2,2],[2,1,4],[1,1,2,1],[1,0,1,0]]

        var q3 = new Q3();
        long[] nums = new long[] {3, 5, 6};
        long[][] queries = new long[][] {
            {1, 0, 2, 2},
            {2, 1, 4},
            {1, 1, 2, 1},
            {1, 0, 1, 0}
        };
        int[] result = q3.popcountDepth(nums, queries);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
