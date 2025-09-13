package v1.pattern.arr_and_hashing;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram_242 {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> freq = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }

        for (char c : s.toCharArray()) {
            if (!freq.containsKey(c)) {
                freq.put(c, 1);
            } else {
                int count = freq.get(c);
                freq.put(c, count + 1);
            }

        }

        for (char c : t.toCharArray()) {
            if (!freq.containsKey(c)) {
                return false;
            }
            int count = freq.get(c);
            if (count < 1) {
                return false;
            } else {
                freq.put(c, count - 1);
            }

        }
        return true;
    }

    public static void main(String[] args) {
        var sol = new IsAnagram_242();
        String s = "aacc";
        String t = "ccac";
        System.out.println(sol.isAnagram(s, t));
    }
}
