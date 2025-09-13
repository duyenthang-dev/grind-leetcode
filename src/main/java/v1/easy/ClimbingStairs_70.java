package v1.easy;

/**
 * Ý tưởng: số cách leo cầu thang của bậc n bằng tổng số cách leo cầu thang của bậc (n -1) và (n -2);
 */

public class ClimbingStairs_70 {
    public static int climbStairs(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;

        for(int i=2;i<n;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n-1];

    }
    public static void main(String[] args) {
        System.out.println(ClimbingStairs_70.climbStairs(2));
    }
}
