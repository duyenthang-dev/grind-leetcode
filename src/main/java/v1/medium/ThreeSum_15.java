package v1.medium;

import java.util.*;

public class ThreeSum_15 {
    /*
    * Using hashmap - not good solution, but pass all test cases anyway
    * */
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for (int i =0; i < nums.length; i++) {
            int target = 0 - nums[i];
            var x = findTwoSum(nums, target, i);
            if (x != null) {
                res.addAll(x);
            }
        }
        return res.stream().toList();
    }

    private List<List<Integer>> findTwoSum(int[] nums, int target, int existedIndex) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = existedIndex + 1; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp)) {
                var triplet = new ArrayList<Integer>();
                triplet.addAll(List.of(-target, nums[i], tmp));

                res.add(triplet);
            }
            map.put(nums[i], i);
        }
        return res;
    }


    /*
    * Same ideas, but using 2 pointers to represent num2 and num3
    * */
    public List<List<Integer>> threeSum_2pointers(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for (int i =0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k =nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    var temp = List.of(nums[i], nums[j], nums[k]);
                    res.add(temp);
                    j++;
                    k--;
                }
                else if (sum > 0) {
                    k--;
                }
                else {
                    j++;
                }
            }
        }
        return res.stream().toList();
    }

    public static void main(String[] args) {
        //[]
        int[] nums = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        var res = new ThreeSum_15().threeSum(nums);
        for (var x: res) {
            System.out.println(x);
        }
    }
}
