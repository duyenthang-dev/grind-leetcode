package medium;

public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        for (int i =0, j = height.length -1; i < j;) {
            int max = (j - i) * (Math.max(height[i], height[j] ) -Math.abs(height[i] - height[j]));


        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(new ContainerWithMostWater_11().maxArea(arr));
    }
}
