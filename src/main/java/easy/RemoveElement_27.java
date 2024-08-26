package easy;

public class RemoveElement_27 {
    static int removeElement(int[] nums, int val) {
        short tail = (short) ((short) nums.length - 1);
        short k = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean breakInner = false;
            while (tail >= i && !breakInner) {
                if (nums[i] == val && nums[tail] != val) {
                    nums[i] = nums[i] + nums[tail];
                    nums[tail] = nums[i] - nums[tail];
                    nums[i] = nums[i] - nums[tail];
                    breakInner = true;
                    ++k;
                    --tail;
                }
                else if (nums[i] == val && nums[tail] == val) {
                    --tail;
                }
                else if (nums[i] != val) {
                    breakInner = true;
                    ++k;
                }
            }
        }
        return k;
    }
    public static void main(String[] args) {
        int [] arr = new int[] {3,2,2,3};
        int val = 3;
        System.out.println(removeElement(arr, val));
    }
}
