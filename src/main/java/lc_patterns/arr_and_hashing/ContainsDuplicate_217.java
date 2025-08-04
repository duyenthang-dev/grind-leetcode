package lc_patterns.arr_and_hashing;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate_217 {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Boolean> existMap = new HashMap<>();

        for (int i : nums) {
            if (!existMap.containsKey(i)) {
                existMap.put(i, true);
            }
            else return true;
        }
        return false;
    }
    public static void main(String[] args) {
        var sol = new ContainsDuplicate_217();
        int[] nums = new int[] {1, 1};
        System.out.println(sol.containsDuplicate(nums));
    }
}
