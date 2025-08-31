package lc_patterns.twopointers.easymedium;

import java.util.Arrays;
import java.util.HashMap;

public class LongestStrChain_1048 {
    public int longestStrChain(String[] words) {
        var map = new HashMap<String, Integer>();
        String[] sortedWords = Arrays.stream(words)
                .sorted((a, b) -> a.length() - b.length())
                .toArray(String[]::new);

        for (var word : sortedWords) {

            map.put(word, 1);
            for (int i = 0; i < word.length(); i++) {
                String pred = word.substring(0, i) + word.substring(i + 1);
                if (map.containsKey(pred)) {
                    map.put(word, Math.max(map.getOrDefault(word, 0), map.get(pred) + 1));
                }
            }

        }

        int max = map.values().stream()
                .mapToInt(Integer::intValue)
                .max().orElse(0);

        return max;

    }

    public static void main(String[] args) {
        var longestStrChain = new LongestStrChain_1048();
        System.out.println(longestStrChain.longestStrChain(new String[] { "a", "b", "ba", "bca" }));
    }
}
