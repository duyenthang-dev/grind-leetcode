package easy;
/**
 * @author duyenthang
 * @since 2024-02-01
 * time spent: 7m
 */
public class ValidPalindrome_125 {
    public boolean isPalindrome(String s) {
        for (short i = 0, j = (short) (s.length() - 1); i <= j;) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }
            if (!String.valueOf(s.charAt(i)).equalsIgnoreCase(String.valueOf(s.charAt(j))))
                return false;
            else {
                i++;
                j--;
            }

        }
        return true;
    }
    public static void main(String[] args) {
        String s = "  A man, a plan, a canal: Panama";
        System.out.println(new ValidPalindrome_125().isPalindrome(s));
    }
}
