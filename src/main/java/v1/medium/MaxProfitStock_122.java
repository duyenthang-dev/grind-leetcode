package v1.medium;

import java.util.ArrayList;
import java.util.List;

public class MaxProfitStock_122 {
    static int maxProfit(int[] prices) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        if (prices.length == 1)
            return 0;
        int curr = 0;
        int start = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] < prices[i]) {
                start++;
            } else break;
        }

        left.add(prices[start]);
        curr = prices[start];
        int i = start + 1;

        while (i < prices.length ) {
            if (prices[i] >= curr && prices[i] >= prices[i - 1]) {
                i++;
            } else {
                right.add(prices[i - 1]);
                left.add(prices[i]);
                curr = prices[i];
                i++;
            }
        }

        if (prices[prices.length - 1] >= prices[prices.length - 2]) {
            right.add(prices[prices.length - 1]);
        }
        int sum = 0;
        for(int t =0; t < right.size(); t++) {
            sum += (right.get(t) - left.get(t));
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,9,6,9,1,7,1,1,5,9,9,9};
        System.out.println(maxProfit(prices));
    }
}
