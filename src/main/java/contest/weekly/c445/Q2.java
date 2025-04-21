package contest.weekly.c445;

import java.util.Arrays;

public class Q2 {
    public String smallestPalindrome(String s) {
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        char[] arr = new char[s.toCharArray().length];
        int len = charArr.length;
        int idx = 0;
        int i = 0;
        for (; i <= charArr.length - 1; i += 1) {
            if (i == charArr.length - 1) {
                arr[arr.length / 2] = charArr[i];
                break;
            }
            if (charArr[i + 1] == charArr[i]) {
                arr[idx] = charArr[i];
                arr[len - idx - 1] = charArr[i];
                i++;
                idx++;
            } else {
                arr[arr.length / 2] = charArr[i];
            }

        }

        return new StringBuffer().append(arr).toString();
    }

    public static void main(String[] args) {
        var sol = new Q2();
        System.out.println(sol.smallestPalindrome(""));
    }
}
