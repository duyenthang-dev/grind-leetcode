package contest.weekly.c445;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/*
 * Hard problem, after spending 80min, the solution sill got TLE
 */
public class Q3 {
    public String smallestPalindrome(String s, int k) {
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        List<Character> lst = new LinkedList<>();
        for (int i = 0; i < charArr.length - 1; i++) {
            if (charArr[i + 1] == charArr[i]) {
                lst.add(charArr[i + 1]);
                i++;
            }
        }

        char[] arr = new char[lst.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = lst.get(i);
        }

        int count = 0;
        Set<String> set = new LinkedHashSet<>();
        do {
            String s1 = new StringBuffer().append(arr).toString();
            if (!set.contains(s1)) {

                set.add(s1);
            }
            count++;
            if (count == k) {
                break;
            }

        } while (nextPermuation(arr));

        if (count < k) {
            return "";
        }

        var resArr = set.stream().toArray(String[]::new);
        var res = resArr[resArr.length - 1];

        char[] arrResult = new char[s.length()];
        for (int i = 0; i < arrResult.length / 2; i++) {
            arrResult[i] = res.charAt(i);
            arrResult[arrResult.length - 1 - i] = res.charAt(i);
        }

        if (s.length() % 2 == 1) {
            arrResult[arrResult.length / 2] = s.charAt(s.length() / 2);
        }

        return new StringBuffer().append(arrResult).toString();
    }

    private boolean nextPermuation(char[] arr) {
        int n = arr.length;
        int pivot = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                pivot = i;
                break;
            }
        }

        if (pivot == -1) {
            reverse(arr, 0, n - 1);
            return false;
        }

        for (int i = n - 1; i > pivot; i--) {
            if (arr[i] > arr[pivot]) {
                char temp = arr[i];
                arr[i] = arr[pivot];
                arr[pivot] = temp;
                break;
            }
        }

        reverse(arr, pivot + 1, n - 1);
        return true;
    }

    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        var sol = new Q3();
        System.out.println(sol.smallestPalindrome("abba", 2));
    }
}
