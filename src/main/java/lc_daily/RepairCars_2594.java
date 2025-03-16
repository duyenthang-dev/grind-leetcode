package lc_daily;

import java.util.Arrays;
/**
 * Ta biết chắc chắn time cần để repair một xe nằm trong khoảng [0, maxRank * cars * cars].
 * Với mỗi time = x, 0 <= x <= maxTime , ta kiểm tra xem các mechanic có thể sửa được cars xe không. => Dùng binary search để tìm x.
 * Giả sử 1 mechanic rank Ri có thể sửa Ni xe -> Ri * Ni * Ni <= x -> Ni <= sqrt(x / Ri).
 * Giả sử tất cả mechanic có thể sửa được cars xe thì tổng số xe mà các mechanic có thể sửa được là Sum(Ni) >= cars.
 * => Nếu có thể sửa đc ta giảm high = mid - 1 để thử với x nhỏ hơn
 * Ngược lại tăng low = mid + 1 để thử với x lớn hơn.
 */
public class RepairCars_2594 {
    public long repairCars(int[] ranks, int cars) {
        long high = (long) Arrays.stream(ranks).max().getAsInt() * cars * cars;
        long low = 0;
        long res = high;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (canRepair(ranks, cars, (int) mid)) {
                high = mid - 1;
                res = (int) mid;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    private boolean canRepair(int[] ranks, long cars, long maxTime) {
        long count = 0;
        for (int i = 0; i < ranks.length; i++) {
           count += Math.sqrt(maxTime * 1.0 / ranks[i]);
        }
        
        return count >= (long) cars;
    }

    public static void main(String[] args) {
        var sol = new RepairCars_2594();
        int cars = 52;
        int[] ranks = new int[] {3};
        System.out.println(sol.repairCars(ranks, cars));
    }
}
