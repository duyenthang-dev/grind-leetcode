package v1.pattern.slidlingwindow;

import java.util.HashMap;

// bài toán trở về tìm sub array có size nhỏ nhất sao cho chúng có chứa 2 value duplicate nhau
// -> sliding window
public class MinimumCardPickup_2260 {
    public int minimumCardPickup(int[] cards) {
        // sliding window shortest
        // extend window to reach valid condition first: map.put(cards[right], map.getOrDefault(cards[right], 0) + 1);
        // then try to shrink the window to make it as short as possible
        // while(map.get(cards[right]) == 2) ...
        var map = new HashMap<Integer, Integer>();
        int left = 0;
        int shortest = cards.length + 1;
        for (int right =0; right < cards.length; right++) {
            map.put(cards[right], map.getOrDefault(cards[right], 0) + 1);
            while(map.get(cards[right]) == 2) {
                map.put(cards[left], map.get(cards[left]) - 1);
                shortest = Math.min(shortest, right - left + 1);
                ++left;
            }
        }
        return shortest != cards.length + 1 ? shortest: -1;
    }
    public static void main(String[] args) {
        
    }
}
