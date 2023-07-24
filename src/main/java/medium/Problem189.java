package medium;

public class Problem189 {
    static void rotate(int[] nums, int k) {
        if (nums.length == 1 || k == 0)
            return;
        int[] tempArr = new int[nums.length];
        for (int i =0; i < nums.length; i++) {
            int j = (i + k) % nums.length;
            tempArr[j] = nums[i];
        }
        System.arraycopy(tempArr, 0, nums, 0, nums.length);

    }
    public static void main(String[] args) {
        int[] nums = new int[] {-1,-100,3,99};
        int k = 2;
        rotate(nums, k);
    }
}
