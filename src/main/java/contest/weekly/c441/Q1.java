package contest.weekly.c441;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q1 {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i =0; i < nums.length; i++) {
            if (nums[i] > 0) {

                set.add(nums[i]);
            } 
        }
        if (set.isEmpty()) {
            set.add(Arrays.stream(nums).max().getAsInt());
        }
        return set.stream().mapToInt(i -> i).sum();
    }

    public static void main(String[] args) {
        var sol = new Q1();
        int []nums = new int[] {0, 0};
        System.out.println(sol.maxSum(nums));
    }
}
