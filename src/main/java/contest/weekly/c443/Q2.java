package contest.weekly.c443;

import java.util.ArrayList;
import java.util.List;

public class Q2 {
    public int longestPalindrome(String s, String t) {
        int max = Integer.MIN_VALUE;
        var subS = genSubstring(s);
        var subT = genSubstring(t);
        for (String sS: subS) {
            for (String sT: subT) {
                String combined = sS + sT;
                if (isPalindrome(combined)) {
                    max = Math.max(max, combined.length());
                }
            }
        }
        return max;
    }

    private List<String> genSubstring(String s) {
        List<String> subs = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                subs.add(s.substring(i, j));
            }
        }
        subs.add(""); 
        return subs;
    }


    private boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        var sol = new Q2();
        String s = "hc";
        String t = "jooh";
        System.out.println(sol.longestPalindrome(s, t));
    }
}
