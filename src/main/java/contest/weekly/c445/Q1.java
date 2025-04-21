package contest.weekly.c445;

public class Q1 {
    public int findClosest(int x, int y, int z) {
        int dis1 = Math.abs(z -x);
        int dis2 = Math.abs(z - y);
        return dis1 > dis2 ? 2: dis1 == dis2 ? 0: 1;
    }
    public static void main(String[] args) {
        var sol = new Q1();
        System.out.println(sol.findClosest(2, 7, 4));
    }
}
