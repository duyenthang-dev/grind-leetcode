package v1.medium;

import java.util.*;

public class LongestConsecutiveSequence_128 {
    public int longestConsecutive(int[] nums) {
        var map = new HashMap<Integer, Boolean>();
        for (int num : nums) {
            map.put(num, true);
        }
        var arr = new ArrayList<Integer>();
        for (var entry : map.entrySet()) {
            arr.add(entry.getKey());
        }

        Collections.sort(arr);

        int max = Integer.MIN_VALUE;
        int count = 1;
        if (nums.length == 0)
            return 0;

        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i + 1) - arr.get(i) == 1) {
                count++;
            }
            else {
                if (count > max) {
                    max = count;
                }
                count = 1;
            }
        }
        if (count > max) {
            max = count;
        }
        return max;
    }

    public static void main(String[] args) {
        var nums = new int[]{100,4,200,1,3,2};
//        var nums = new int[]{0,3,7,2,5,8,4,6,0,1};
//        var nums = new int[]{1,2,0,1};
//        var nums = new int[]{0,1,2,4,8,5,6,7,9,3,55,88,77,99,999999999};
//        var nums = new int[]{0, 0};
//        var nums = new int[]{0};
        System.out.println(new LongestConsecutiveSequence_128().longestConsecutive(nums));
    }
}