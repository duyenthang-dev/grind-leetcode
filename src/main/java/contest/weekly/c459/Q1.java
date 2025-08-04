package contest.weekly.c459;

import java.util.ArrayList;

public class Q1 {
    public boolean checkDivisibility(int n) {
        int tmp = n;
        var lst = new ArrayList<Integer>();
        while(tmp > 0) {
            int digit = tmp % 10;
            lst.add(digit);
            tmp /= 10; 
        }

        long sum = 0;
        long prod = 1;
        for (var i : lst) {
            sum += i;
        }

        for (var i: lst) {
            prod *= i;
        }

        return n % (sum + prod) == 0;
    }
    public static void main(String[] args) {
        var q1 = new Q1();
        System.out.println(q1.checkDivisibility(19));
    }
}
