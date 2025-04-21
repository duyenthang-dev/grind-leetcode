/**
 * @author [Thắng, Hà Duyên]
 * @email [duyenthang.dev@gmail.com]
 * @create date 2025-04-20 22:30:43
 * @modify date 2025-04-20 22:30:43
 * @desc [leetcode daily]
 * @timeTaken: 33min
 */

package lc_daily;

import java.util.HashMap;
import java.util.Map;

public class NumRabbits_781 {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < answers.length; i++) {
            map.put(answers[i], map.getOrDefault(answers[i], 0) + 1);
        }

        int count = 0;
        for (var entry : map.entrySet()) {
            int freq = entry.getValue();
            int key = entry.getKey() + 1;
            count += Math.ceil(freq * 1.0 / key) * key;

        }

        return count;
    }

    public static void main(String[] args) {
        var sol = new NumRabbits_781();
        var ans = new int[] { 2, 2, 2, 2, 3 };
        System.out.println(sol.numRabbits(ans));
    }
}
