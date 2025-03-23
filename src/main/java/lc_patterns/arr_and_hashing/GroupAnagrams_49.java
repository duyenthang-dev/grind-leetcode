package lc_patterns.arr_and_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        var map = new HashMap<String, List<String>>();
        for (var str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>(List.of(str)));
            } else {
                var existing = map.get(sorted);
                existing.add(str);
                map.put(sorted, existing);
            }
        }

        return map.values().stream().toList();
    }

    public static void main(String[] args) {
        // var sol = new GroupAnagrams_49();
    }
}
