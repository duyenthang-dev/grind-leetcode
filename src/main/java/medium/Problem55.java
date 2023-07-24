package medium;

public class Problem55 {
    static boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;
        for (int i = nums.length - 2; i >=0;) {
            if (nums[i] == 0) {
                int j = i - 1;
                boolean end = true;
                while (end && j >=0) {
                    if (nums[j] > (i - j) && nums[j] != 0) {
                        end = false;
                    }
                    else if (nums[j] == 0) {
                        j--;
                        continue;
                    }
                    j--;
                }
                if (end) {
                    return false;
                }
                i = j;
            }
            else {
                i--;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] nums = new int[] {2,3,1,1,4};
        System.out.println(canJump(nums));
    }
}
