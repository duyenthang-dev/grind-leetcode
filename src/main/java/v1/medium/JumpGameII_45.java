package v1.medium;

/**
 * <a href="https://leetcode.com/problems/jump-game-ii/solutions/1192401/easy-solutions-w-explanation-optimizations-from-brute-force-to-dp-to-greedy-bfs/?envType=study-plan-v2&envId=top-interview-150">Solutions</a>
 */

public class JumpGameII_45 {
    static int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i =0; i < nums.length; i++) {
            dp[i] = 10001;
        }
        return jump(nums, dp, 0);
    }
    static int jump(int[] nums, int[] dp, int pos) {
        if (pos >= nums.length - 1)
            return 0;
        if(dp[pos] != 10001) return dp[pos];
        for (int i =1; i <= nums[pos]; i++) {
            dp[pos] = Math.min(dp[pos], 1 + jump(nums,  dp, pos + i));
        }
        return  dp[pos];
    }
    public static void main(String[] args) {
        int[] nums = new int[] {2,3,1,1,4};
        System.out.println(jump(nums));
    }
}
