package v1.easy;

/**
 * Ý tưởng
 */

public class PlusOne_66 {
    public static int[] plusOne(int[] digits) {
        int i = digits.length -1;
        while (i >= 0) {
            digits[i] += 1;
            if (digits[i] == 10) {
                digits[i] = 0;
                i--;
            }
            else break;
        }
        if (digits[0] == 0) {
            int[] newArr = new int[digits.length + 1];
            newArr[0] = 1;
            for (int j = 1; j < newArr.length; j++){
                newArr[j] = 0;
            }
            return newArr;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] digit = new int[]{9};
        System.out.println(PlusOne_66.plusOne(digit));
    }
}
