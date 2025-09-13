package v1.pattern.twopointers.easymedium;

// time complexity ko thực sự tốt, chỉ dùng 2 pointers, ko dùng DP 
// ý tưởng hiện tại: với mỗi left wall, cố gắng tìm right wall tương ứng có thể đựng nước
// -> luôn phải duyệt right wall từ cuối mảng để tìm -> O(n2)
// tham khảo approach tốt hơn: https://leetcode.com/problems/trapping-rain-water/solutions/1374608/c-java-python-maxleft-maxright-so-far-with-picture-o-1-space-clean-concise
public class Trap_42 {
    public int trap(int[] height) {
        int count = 0;
        int i = 0;
        int right = height.length - 1;
        if (height.length <= 1)
            return 0;

        // từ trái sang, skip  tới khi cột liền kề thấp hơn hiện tại
        while (i < height.length - 2 && height[i] < height[i + 1]) {
            i++;
        }

        // từ phải qua,  skip  tới khi cột liền kề cao hơn hiện tại
        while (right >= 1 && height[right - 1] >= height[right]) {
            right--;
        }
        if (right == 0) {
            return 0;
        }
        while (i < right) {
            int j = right;
            int posibleRightWallIdx = right;
            int max = Integer.MIN_VALUE;
            int black = 0;
            // find posibleRightWallIdx from i
            while(j > i) {
                if (height[j] > max) {
                    posibleRightWallIdx = j;
                    max = height[j];
                    black = 0;
                }
                else if (height[j] >= height[i]) {
                    posibleRightWallIdx = j;
                    max = height[j];
                    black = 0;
                }
                else {
                    black += Math.min(height[j], height[posibleRightWallIdx]) * 1;
                }
                j--;
            }
            if (posibleRightWallIdx == i + 1) {
                i++;
                continue;
            }

            count += (posibleRightWallIdx - i - 1) * Math.min(height[i], height[posibleRightWallIdx]) - black;
            i = posibleRightWallIdx;
        }
        return count;
    }

    public static void main(String[] args) {
        var height = new int[] {5 ,4 , 4};
        System.out.println(new Trap_42().trap(height));
    }
}
