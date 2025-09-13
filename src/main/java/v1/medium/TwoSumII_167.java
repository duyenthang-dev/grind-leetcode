package v1.medium;
/**
 * @author duyenthang
 * @since 2024-02-01
 * time spent: 9m
 */
public class TwoSumII_167 {
    public int[] twoSum(int[] numbers, int target) {
        for (short i = 0, j = (short) (numbers.length - 1); i < j;) {
            if (numbers[j] > target - numbers[i]) {
                j--;
            }
            else if (numbers[j] < target - numbers[i]) {
                i++;
            }
            else return new int[] {++i, ++j};

        }
        return null;
    }
    public static void main(String[] args) {
        int[] nums = {-1,0};
        int target = -1;
        int [] res = new TwoSumII_167().twoSum(nums, target);
        for (var i: res) {
            System.out.print(i + " ");
        }
    }
}
