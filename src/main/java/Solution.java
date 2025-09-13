import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution {
    public static int findFirstOccurrence(List<Integer> arr, int target) {
        // WRITE YOUR BRILLIANT CODE HERE
        int idx = -1;
        int l = 0;
        int r = arr.size() - 1;
        int mid = -1;
        while (l <= r) {
            mid = (l + r ) /2;
            if (arr.get(mid) > target) {
                r = mid - 1;
            }
            else if (arr.get(mid) == target){
                idx = mid;
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return idx;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int target = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = findFirstOccurrence(arr, target);
        System.out.println(res);
    }
}
