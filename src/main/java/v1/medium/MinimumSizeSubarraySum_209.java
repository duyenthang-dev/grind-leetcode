package v1.medium;

public class MinimumSizeSubarraySum_209 {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int right = -1;
        int sum = 0;
        int len = nums.length;
        while (left < len) {
            if (sum >= target) {
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left];
                left++;
            }
            else {
                if (right == len - 1)
                    break;
                right++;
                sum += nums[right];

            }
        }
        return ans == Integer.MAX_VALUE? 0: ans;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(new MinimumSizeSubarraySum_209().minSubArrayLen(target, nums));
    }
}
