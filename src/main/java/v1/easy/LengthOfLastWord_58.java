package v1.easy;

public class LengthOfLastWord_58 {
    static int lengthOfLastWord(String s) {
       String s1 = s.trim();
       int count = 0;
       for(int i = s1.length() - 1; i >= 0; i--) {
           if (s1.charAt(i) == ' ') {
               return count;
           }
           else count++;
       }
       return count;
    }
    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s));
    }
}
