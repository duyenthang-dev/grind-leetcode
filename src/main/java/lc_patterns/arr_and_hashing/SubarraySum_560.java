package lc_patterns.arr_and_hashing;

import java.util.HashMap;


// 1 4 2 -6 5 8, k = 6
/*
 * 1: 1, [1, 4, 2, -6]
 * 5: 1, 4
 * 7: 1,4 ,2
 * 12: 1, 4, 2, 5
 * 20: 1, 4, 2, 5, 12
 * -> hash map để lưu key = tổng của current subArr, value = freq (do có thể có số âm nên 2 contiguous currSubArray khác nhau có thể trùng sum)
 */
public class SubarraySum_560 {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int s = 0;
        var map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        for (int i =0; i < nums.length; i++) {
            s += nums[i];
            if (map.containsKey(s - k)) {
                count += map.get(s - k);
            }

            map.put(s, map.getOrDefault(s, 0) + 1);

        }
        return count;
    }
    public static void main(String[] args) {
        var sol = new SubarraySum_560();
        System.out.println(sol.subarraySum(new int[]{1,1,1}, 2));
        
    }
}
