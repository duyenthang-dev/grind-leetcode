package contest.weekly.c442;

public class Q1 {
    public int maxContainers(int n, int w, int maxWeight) {
        int max = maxWeight / w;
        if (n*n < max) {
            return n*n;
        }
        else return max;
    }
    public static void main(String[] args) {
        var sol = new Q1();
        int n = 2;
        int w = 3;
        int maxWeight = 15;
        System.out.println(sol.maxContainers(n, w, maxWeight));   
    }
}
