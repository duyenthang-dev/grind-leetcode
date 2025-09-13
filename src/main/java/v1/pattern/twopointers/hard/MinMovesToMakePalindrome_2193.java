package v1.pattern.twopointers.hard;

public class MinMovesToMakePalindrome_2193 {
    public int minMovesToMakePalindrome(String s) {
        int count = 0;
        int i =0;
        int j = s.length() -1;
        char[] arr = s.toCharArray();
        while (i < j) {
            int idx = j;
            for (; idx > i; idx--) {
                if (arr[idx] == arr[i]) {
                    for (; idx < j; idx++) {
                        char temp = arr[idx];
                        arr[idx] = arr[idx + 1];
                        arr[idx + 1] = temp;
                        count++;
                    }
                    j--;
                    break;
                }
            }
            if (idx == i) {
                count += arr.length / 2 -i;
            }
           i++;
        }
        return count;
    }


    public static void main(String[] args) {
        var sol = new MinMovesToMakePalindrome_2193();
        String s = "eqvvhtcsaaqtqesvvqch";
        System.out.println(sol.minMovesToMakePalindrome(s));
    }
}
