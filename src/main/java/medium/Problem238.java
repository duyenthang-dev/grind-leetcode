package medium;

import utils.PrinterUtils;

import java.util.Arrays;

public class Problem238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        pre[0] = nums[0];
        suf[n - 1] = nums[n - 1];

        for (int i =1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i];
        }

        for (int j = n - 2; j >= 0; j--) {
            suf[j] = nums[j] * suf[j + 1];
        }
        int[] res = new int[n];
        for (int i =0; i < n; i++) {
            int p = 1;
            int s = 1;
            if (i != 0)
                p = pre[i - 1];
            if (i != n - 1)
                s = suf[i + 1];
            res[i] =  p * s;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,1,0,-3,3};
        System.out.println( new PrinterUtils<Integer>().printArray(Arrays.stream(new Problem238().productExceptSelf(nums)).boxed().toArray(Integer[]::new)));
    }
}
