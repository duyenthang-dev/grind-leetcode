package easy;

public class MaxProfitStock_121 {
    static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int p = 0;
        int p1 = 0;
        for(int i =  0; i < prices.length;  i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            p1 = prices[i] - min;
            if (p < p1) {
                p = p1;
            }
        }
        return p;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,2,5,1,6,4};
        System.out.println(maxProfit(arr));
    }
}
