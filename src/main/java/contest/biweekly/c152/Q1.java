package contest.biweekly.c152;

import java.util.HashSet;
import java.util.Set;

public class Q1 {
    public int totalNumbers(int[] digits) {
        int[] count = new int[10]; // Frequency array for digits 0-9
        for (int digit : digits) {
            count[digit]++;
        }

        Set<Integer> uniqueNumbers = new HashSet<>();

        for (int a = 1; a <= 9; a++) {
            if (count[a] == 0) continue;

            count[a]--; 
            for (int b = 0; b <= 9; b++) {
                if (count[b] == 0) continue;

                count[b]--;

                for (int c = 0; c <= 8; c += 2) {
                    if (count[c] == 0) continue;

                    int number = a * 100 + b * 10 + c;
                    uniqueNumbers.add(number);
                }

                count[b]++; // Backtrack
            }

            count[a]++; // Backtrack
        }

        return uniqueNumbers.size();
    }


    public static void main(String[] args) {
        var sol = new Q1();
        var digits = new int[] {1, 2, 3, 4};
        System.out.println(sol.totalNumbers(digits));
    }
}
