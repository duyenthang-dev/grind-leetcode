package easy;

public class RemoveDuplicates_26 {
    public static int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; ) {
            nums[k] = nums[i];
            while (true) {
                if (i == nums.length - 1)
                    return k + 1;
                if (nums[++i] == nums[k])
                    continue;
                else break;
            }
            k++;
        }
        return k + 1;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1, 1, 2};
        System.out.println(RemoveDuplicates_26.removeDuplicates(num));
    }
}
