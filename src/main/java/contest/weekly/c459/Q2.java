package contest.weekly.c459;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Q2 {
    private static final int MOD = 1000000007;

public int countTrapezoids(int[][] points) {
    var pointSameY = new HashMap<Integer, Set<Integer>>();
    for (var point : points) {
        pointSameY.computeIfAbsent(point[1], k -> new HashSet<>()).add(point[0]);
    }
    
    long totalPairs = 0;  // Total C(n_i, 2) for all y-coordinates
    long totalSquaredPairs = 0;  // Total C(n_i, 2)^2 for all y-coordinates
    
    for (var xs : pointSameY.values()) {
        if (xs.size() >= 2) {
            long pairs = (long) xs.size() * (xs.size() - 1) / 2;
            totalPairs = (totalPairs + pairs) % MOD;
            totalSquaredPairs = (totalSquaredPairs + (pairs * pairs) % MOD) % MOD;
        }
    }
    
    // Result = (totalPairs)^2 - totalSquaredPairs) / 2
    // This counts each pair of y-coordinates exactly once
    long result = ((totalPairs * totalPairs) % MOD - totalSquaredPairs + MOD) % MOD;
    result = (result * modInverse(2, MOD)) % MOD;
    
    return (int) result;
}

private long modInverse(long a, long mod) {
    return modPow(a, mod - 2, mod);
}

private long modPow(long base, long exp, long mod) {
    long result = 1;
    base %= mod;
    while (exp > 0) {
        if (exp % 2 == 1) {
            result = (result * base) % mod;
        }
        base = (base * base) % mod;
        exp /= 2;
    }
    return result;
}

    public static void main(String[] args) {
       var q2 = new Q2();
       // [0,0],[1,0],[0,1],[2,1]©leetcode
       System.out.println(q2.countTrapezoids(new int[][]{{0,0},{1,0},{0,1},{2,1}}));
    }
}
