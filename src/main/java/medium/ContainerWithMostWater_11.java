package medium;

/**
 * @author duyenthang
 * @since 2024-02-02
 * time spent: 35m
 */
public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        for (int i =0, j = height.length -1; i < j;) {
            int area = (j - i) * Math.min(height[i], height[j]);
            if (area > max)
                max = area;

            if (height[i] <= height[j]) {
                i++;
            }
            else if (height[i] > height[j]) {
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(new ContainerWithMostWater_11().maxArea(arr));
    }
}
