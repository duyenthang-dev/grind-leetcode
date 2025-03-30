package contest.weekly.c443;

import java.util.HashSet;
import java.util.Set;

public class Q2 {
    public  int longestPalindrome(String s, String t) {
        int maxLength = 1;
        String bestCombination = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String subS = s.substring(i, j + 1);
                if (isPalindrome(subS) && subS.length() > maxLength) {
                    maxLength = subS.length();
                    bestCombination = subS;
                }
            }
        }
        for (int i = 0; i < t.length(); i++) {
            for (int j = i; j < t.length(); j++) {
                String subT = t.substring(i, j + 1);
                if (isPalindrome(subT) && subT.length() > maxLength) {
                    maxLength = subT.length();
                    bestCombination = subT;
                }
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String subS = s.substring(i, j + 1);

                for (int k = 0; k < t.length(); k++) {
                    for (int l = k; l < t.length(); l++) {
                        String subT = t.substring(k, l + 1);
                        String combined = subS + subT;

                        if (isPalindrome(combined) && combined.length() > maxLength) {
                            maxLength = combined.length();
                            bestCombination = combined;
                        }
                    }
                }
            }
        }

        return maxLength;
    }

    private  boolean isPalindrome(String str) {
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
        String s = "a";
        String t = "bbbb";
        System.out.println(sol.longestPalindrome(s, t));
    }
}
