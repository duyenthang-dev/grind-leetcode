package lc_patterns.twopointers.easymedium;

import java.util.Arrays;
/*
 * cách làm
 * sort mảng và dùng 2 pointer để thực hiện giải thuật tham lam
 * -> O(nlogn)
 */
public class NumRescueBoats_881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res = 0;
        int i = 0;
        for (int j = people.length - 1; j >= i; j--) {
            int s = people[j];
            int c = 1;
            while (i < j && s + people[i] <= limit && c < 2) {
                s += people[i];
                i++;
                c++;
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        var sol = new NumRescueBoats_881();
        int[] arr = new int[] { 2, 49, 10, 7, 11, 41, 47, 2, 22, 6, 13, 12, 33, 18, 10, 26, 2, 6, 50, 10 };
        int limit = 50;
        System.out.println(sol.numRescueBoats(arr, limit));
    }
}
