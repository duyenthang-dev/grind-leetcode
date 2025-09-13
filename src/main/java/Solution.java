import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution {
    public static int subarraySumShortest(List<Integer> nums, int target) {
        // WRITE YOUR BRILLIANT CODE HERE
        int res = nums.size();
        int left = 0;
        int right = 0;
        int s = 0;
        while (right < nums.size()) {
            s += nums.get(right);
            right++;
            while (s >= target) {
                res = Math.min(res, right - left);
                s -= nums.get(left);
                left++;
            }
        }
        if (res == 0)
            return 1;
        return res;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int target = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = subarraySumShortest(nums, target);
        System.out.println(res);
    }
}
