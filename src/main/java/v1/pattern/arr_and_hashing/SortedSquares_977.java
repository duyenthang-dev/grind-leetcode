package v1.pattern.arr_and_hashing;

/*
 * 2 pointer
 * mảng đã sắp theo thứ tự bé -> lớn -> số bình phương lớn nhât có thể sẽ bắt đầu từ l or r
 * dùng 2 pointer xét từng cặp 1
 * cách nhận biết pattern:  
 */
public class SortedSquares_977 {
    public int[] sortedSquares(int[] nums) {
        int l=0, r= nums.length -1;
        int n = 0;
        int i = nums.length - 1;
        var res = new int[nums.length];
        while (l <= r) {
            int nl = nums[l] * nums[l];
            int nr = nums[r] * nums[r];
            if (nl > nr) {
                n = nl;
                l++;
            }else if (nl <= nr) {
                n = nr;
                r--;
            }
            res[i--] = n;
        }
        return res;
        
    }
    public static void main(String[] args) {
        var sol = new SortedSquares_977();
        var nums = new int[]{-7,-3,2,3,11};
        var res = sol.sortedSquares(nums);
        for (int n: res) {
            System.out.println(n);
        }
    }
}
