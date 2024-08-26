package medium;

import java.util.HashMap;

/**
 * Runtime: 7ms - beat 44.7% java user
 * Memory: 43.64mb - beat 84% java user
 */
public class LongestSubstring_3 {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        var existenceMap = new HashMap<Character, Integer>();
        int l = 0;
        int r = 0;
        while (l < s.length()) {
            if (r == s.length()) {
                ans = Math.max(ans, r - l);
                break;
            }
            if (!existenceMap.containsKey(s.charAt(r))) {
                existenceMap.put(s.charAt(r), 1);
            }
            else {
                existenceMap.put(s.charAt(r), existenceMap.get(s.charAt(r)) + 1);
            }

            if (existenceMap.get(s.charAt(r)) > 1) {
                ans = Math.max(ans, r - l);
                while (s.charAt(r) != s.charAt(l))
                {
                    existenceMap.put(s.charAt(l), 0);
                    l++;
                }
                existenceMap.put(s.charAt(l), 1);
                l++;
            }
            r++;

        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "a";
        System.out.println(new LongestSubstring_3().lengthOfLongestSubstring(s));
    }
}
