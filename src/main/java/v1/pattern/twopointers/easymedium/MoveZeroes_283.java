package v1.pattern.twopointers.easymedium;

/**
 * @author: thangha
 * @created: 10/10/2023
 * cách làm: sử dụng 2 con trỏ i, j để duyệt mảng, i là chỉ số cho phần tử hiện tại, j là chỉ số cho phần tử khác 0
 */
public class MoveZeroes_283 {
    public void moveZeroes(int[] nums) {
        int i =0;
        int j = 0;
        for (int num : nums) {
            if (num != 0) {
                i++;
                j++;
            }
            else {
                break;
            }
        }
        while(j < nums.length) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
                nums[j] = 0; 
            }
            j++;
        }

    }


    public static void main(String[] args) {
        var moveZeroes = new MoveZeroes_283();
        int[] nums = {1, 1};
        moveZeroes.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
