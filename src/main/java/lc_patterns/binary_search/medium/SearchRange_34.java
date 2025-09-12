package lc_patterns.binary_search.medium;

public class SearchRange_34 {
    public int[] searchRange(int[] nums, int target) {
        // dấu hiệu nhận biết dùng binary search:
        // có dấu hiệu hàm đơn điệu, ở đây là non-decreasing order
        // first pos dùng binary search , gắng đẩy về đầu mảng để tìm idx trái nhất
        // las pos -> gắng đẩy về sau mảng để tìm idx phải nhất
        var res = new int[]{-1, -1};
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                res[0] = mid;
                right = mid - 1;
            }
            else if (nums[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        left = 0;
        right = nums.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                res[1] = mid;
                left = mid + 1;
            }
            else if (nums[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        var sol = new SearchRange_34();
        var nums = new int[]{5,7,7,8,8,10};
        System.out.println(sol.searchRange(nums, 8));
    }
}
