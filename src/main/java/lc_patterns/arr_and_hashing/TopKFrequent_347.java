package lc_patterns.arr_and_hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
public class TopKFrequent_347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqs = new HashMap<>();
        for (int i : nums) {
            if (!freqs.containsKey(i)) {
                freqs.put(i, 1);
            } else {
                freqs.put(i, freqs.get(i) + 1);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue());

        maxHeap.addAll(freqs.entrySet());

        var res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll().getKey();
        }
        return res;
    }

    

    public static void main(String[] args) {
        var sol = new TopKFrequent_347();
        var nums = new int[] { 1, 2 };
        var k = 2;
        var res = sol.topKFrequent(nums, k);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
