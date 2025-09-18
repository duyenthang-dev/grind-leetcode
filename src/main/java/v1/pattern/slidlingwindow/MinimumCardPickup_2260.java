package v1.pattern.slidlingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution {
    public static List<Integer> subarraySum(List<Integer> arr, int target) {
        var map = new HashMap<Integer, Integer>();
        map.put(0, 0);
        int curSum = 0;
        for (int i =0; i < arr.size(); i++) {
            curSum += arr.get(i);
            int complement = curSum - target;
            if (map.containsKey(complement)) {
                return List.of(map.get(complement), i + 1);
            }
            map.put(curSum, i + 1);
        }
        return null;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int target = Integer.parseInt(scanner.nextLine());
        scanner.close();
        List<Integer> res = subarraySum(arr, target);
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}

