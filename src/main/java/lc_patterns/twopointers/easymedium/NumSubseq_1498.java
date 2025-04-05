package lc_patterns.twopointers.easymedium;

import java.util.Arrays;

public class NumSubseq_1498 {
    // 2 ^ (r - l)
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length -  1;
        long res = 0;
        int mod = (int) 1e9 + 7;
        
        while (l <= r) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else {
                res = res + (long) Math.pow(2, r - l);
                l++;
            }
        }
        
        return (int) res % mod;
    }

    public static void main(String[] args) {

        var sol = new NumSubseq_1498();
        int[] nums = new int[] {2,3,3,4,6,7 };
        System.out.println(sol.numSubseq(nums, 12));
    }
}
