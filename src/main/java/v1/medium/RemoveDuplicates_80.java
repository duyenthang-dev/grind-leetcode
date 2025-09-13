package v1.medium;

public class RemoveDuplicates_80 {
    static int removeDuplicates(int[] nums) {
        int k = 0;
        int tail = nums.length - 1;
        int duplicatedCount = 0;
        for(int i =0; i < nums.length - 1 - k; i++) {

            if (nums[i + 1] == nums[i]) {
                ++duplicatedCount;
            }
            else if (nums[i + 1] != nums[i] ){
                duplicatedCount = 0;
            }
            if (duplicatedCount >= 2) {
                for (int j = i + 1 + 1; j <= tail; j++) {
                    nums[j - 1] = nums[j];
                }
                nums[tail] = nums[i + 1];
                ++k;
                --tail;
                --i;
            }

        }
        return nums.length - k;
    }
    public static void main(String[] args) {
        int[] arr = new int[] {1,1,1,2,2,3};
        System.out.println(removeDuplicates(arr));
    }
}
