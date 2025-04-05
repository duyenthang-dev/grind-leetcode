package lc_patterns.twopointers.easymedium;
/*
 * Cách tiếp cận
 * Vì chắc chắn mảng chỉ gồm 3 giá trị 0 1 2 nên ta có thể đếm số lượng từng elem, sau đó loop lại mảng để fill mảng theo thứ tự
 * fill hết 0 trước, sau đó 1, 2
 * Cách 2 dùng 2 pointer
 * - vì mảng chỉ có 3 loại phần tử 0 1 2, nên chắc chắn 0 sẽ ở các vị trí bên trái, 1 ở vị trí giữa và 2 ở vị trí bên phải của mảng
 * - dùng 3 pointer để swap, start, end và current
 * - loop qua mảng, 
 *      nếu là 1 thì giữ nguyên start và cur = cur + 1, 
 *      nếu là 0 thì swap về  nums[start], start++;
 *      nếu là 2 thì đẩy về nums[end], end--;
 */
public class SortColors_75 {
    public void sortColors(int[] nums) {
        int n0 = 0, n1 = 0, n2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                n0++;
            else if (nums[i] == 1)
                n1++;
            else
                n2++;
        }

        for (int i = 0; i < nums.length; i++) {
            while (n0-- > 0) {
                nums[i++] = 0;
            }

            while (n1-- > 0) {
                nums[i++] = 1;
            }
            while (n2-- > 0) {
                nums[i++] = 2;
            }
        }

    }

    public static void main(String[] args) {
        var sol = new SortColors_75();
        int[] nums = new int[] { 2, 0, 2, 1, 1, 0 };
        sol.sortColors(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
