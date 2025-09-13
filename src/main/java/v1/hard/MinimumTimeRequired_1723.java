package v1.hard;

import java.util.Arrays;

public class MinimumTimeRequired_1723 {
    public int minimumTimeRequired(int[] jobs, int k) {
        // nếu có thể done trong t thì có thể done trong t + n sao cho n > 0
        // -> dùng binary
        long sum = Arrays.stream(jobs).sum();
        long l =0, r = sum;
        int res = 0;
        while(l <= r) {
            int mid =(int) (l + r) / 2;
            if (canDone(jobs, k, mid)) {
                res = (int) mid;
                r = mid -1;
            }
            else {
                l = mid + 1;
            }
        }
        return res;

    }

    // backtracking
    private boolean canDone(int[] jobs, int k, int boundary) {
        return false;
    }
    public static void main(String[] args) {
        var sol = new MinimumTimeRequired_1723();
        var jobs = new int[] {};
        int k = 3;
        System.out.println(sol.minimumTimeRequired(jobs, k));
    }
}
