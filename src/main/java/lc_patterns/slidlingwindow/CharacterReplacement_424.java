package lc_patterns.slidlingwindow;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement_424 {
    public int characterReplacement(String s, int k) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int highestFreq = 0;
        int max = 0;

        while (j < chars.length) {
            if (!map.containsKey(chars[j])) {
                map.put(chars[j], 1);

            } else {
                int freq = map.get(chars[j]);
                map.replace(chars[j], ++freq);
            }
            highestFreq = Math.max(highestFreq, map.get(chars[j]));
            int numToReplace = (j - i + 1) - highestFreq;
            if (numToReplace > k) {
                int freq = map.get(chars[i]);
                map.replace(chars[i], --freq);
                i++;
            }
            max = j - i + 1;
            j++;

        }

        return max;
    }

    public static void main(String[] args) {
        var sol = new CharacterReplacement_424();
        String s = "AABABBA";
        int k = 1;
        System.out.println(sol.characterReplacement(s, k));
    }
}
