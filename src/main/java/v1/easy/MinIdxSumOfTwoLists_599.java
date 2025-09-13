package v1.easy;

import java.util.*;
import java.util.stream.Collectors;

public class MinIdxSumOfTwoLists_599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map1 = new HashMap<>();
        String[] l = list1.length < list2.length ? list1: list2;
        String[] m = list1.length >= list2.length ? list1: list2;
        for (int i = 0; i < l.length; i++) {
            map.put(l[i], i);
        }
        int count = 0;
        for (int i = 0; i < m.length && count <= l.length; i++) {
            if (map.containsKey(m[i])) {
                map1.put(m[i], map.get(m[i]) + i);
                count++;
            }
        }
        if (map1.size() == 0)
            return null;
        Map<String, Integer> sorted = map1.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        int leastIdx = sorted.values().stream().findFirst().get();
        Set<String> res = new HashSet<>();
        sorted.forEach((key, value) -> {
            if (value == leastIdx)
                res.add(key);
        });
        String[] result = new String[res.size()];
        return res.toArray(result);
    }
    public static void main(String[] args) {
        String[] l1 = new String[]{"k","KFC"};
        String[] l2 = new String[]{"k","KFC"};
        System.out.println(new MinIdxSumOfTwoLists_599().findRestaurant(l1, l2).toString());
    }
}
