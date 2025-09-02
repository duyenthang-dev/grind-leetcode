package lc_patterns.arr_and_hashing;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// O(n) time complexity and O(1) space complexity
// we easily see that number of elements have freq alway maximum 2 
public class MajorityElement_229 {
    public List<Integer> majorityElement(int[] nums) {
        Integer major1 = 0;
        Integer major2 = 0;
        int count1 = 0;
        int count2 = 0;

        // find 2 majority
        for (int num: nums) {
            if (num == major1) {
                count1++;
            }
            else if (num == major2) {
                count2++;
            }
            else if (count1 == 0) {
                major1 = num;
                count1++;
            }
            else if (count2 == 0) {
                major2 = num;
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }

        // after find 2 major number, let loop again and count freq
        count1 =0;
        count2 = 0;
        for (int num: nums) {
            if (num == major1) {
                count1++;
            }
            if (num == major2) {
                count2++;
            }
        }
        
        // check freq condition
        Set<Integer> set = new HashSet<>();
        if (count1 > nums.length / 3) {
            set.add(major1);
        }

        if (count2 > nums.length / 3) {
            set.add(major2);
        }

        return List.copyOf(set);
    }

    public static void main(String[] args) {
        MajorityElement_229 solution = new MajorityElement_229();
        int[] nums = {0, 0};
        List<Integer> result = solution.majorityElement(nums);
        System.out.println(result);
    }
}

// 1 2 3 2 3 4 4 4