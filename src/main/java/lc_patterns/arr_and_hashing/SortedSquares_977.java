package lc_patterns.arr_and_hashing;

import java.util.Stack;

public class SortedSquares_977 {
    public int[] sortedSquares(int[] nums) {
        int l=0, r= nums.length -1;
        var stack = new Stack<Integer>();
        while (l <= r) {
            int nl = nums[l] * nums[l];
            int nr = nums[r] * nums[r];
            if (nl > nr) {
                stack.push(nl);
                l++;
            }else if (nl <= nr) {
                stack.push(nr);
                r--;
            }
        }

        var res = new int[nums.length];
        int i =0;
        while (!stack.isEmpty()) {
            res[i] = stack.pop();
        }
        return res;
        
    }
    public static void main(String[] args) {
        var sol = new SortedSquares_977();
        var nums = new int[]{-4,-1,0,3,10};
        var res = sol.sortedSquares(nums);
        for (int n: res) {
            System.out.println(n);
        }
    }
}
