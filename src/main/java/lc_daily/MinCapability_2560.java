package lc_daily;

import java.util.Arrays;

// Just remember minimization maximization problems are solved with BS in most of the cases. Only tough Part in such problems is to make logic for handler fun
public class MinCapability_2560 {
    // check liệu có thể trộm đc cap qua k bước ko
    private boolean canSteal(int[] nums, int k, int cap) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= cap) {
                i++;
                count++;
            }

            if (count >= k)
                return true;
        }
        return false;
    }

    // vì đang đi tính maximum của mỗi lần trộm. Nên nếu tên trộm có thể trộm ở k
    // house với cap là x -> hắn có thể trộm k house với bất kì cap nào > x
    // min_arr <= x < max_arr
    // ngc lại nếu tên trộm k thể trộm ở k house với cap là x -> hắn k thể trộm ở k
    // house với bất kì cap < x
    // bài toán tìm min của max.. -> quy về tham lam dùng binary search
    public int minCapability(int[] nums, int k) {
        int left = Arrays.stream(nums).min().getAsInt();
        int right = Arrays.stream(nums).max().getAsInt();

        while (left < right) {
            // binary search: check liệu có thể trộm đc value = mid qua k bước ko
            // nếu có thì giảm cap xuống, cố gắng tìm cap nhỏ nhất thoả điều kiện sao cho
            // vẫn có thể trộm đc qua k bước
            int mid = left + (right - left) / 2;
            if (canSteal(nums, k, mid)) {
                right = mid;
            } else
                left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        var sol = new MinCapability_2560();
        var nums = new int[] { 2, 3, 5, 9 };
        int k = 2;

        System.out.println(sol.minCapability(nums, k));
    }
}
