package v1.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialDigits_1291 {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < 9; ++i) {
            int x = i;
            for (int j = i + 1; j < 10; ++j) {
                x = x * 10 + j;
                if (x >= low && x <= high) {
                    ans.add(x);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
    public static void main(String[] args) {
        int low = 1000;
        int high = 13000;
        System.out.println(new SequentialDigits_1291().sequentialDigits(low, high));
    }
}
