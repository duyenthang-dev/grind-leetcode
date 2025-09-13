package v1.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseWords_151 {
    public String reverseWords_1(String s) {
        StringBuilder sb = new StringBuilder(s);
        removeExtraSpace(sb);
        String[] strArr = sb.toString().split("\\s+");
        for (String str: strArr) {
            StringBuilder sb1 = new StringBuilder(str);
            sb1.reverse();
        }
        List<String> strs = Arrays.asList(strArr);
        Collections.reverse(strs);
        return strs.stream().collect(Collectors.joining(" "));
    }

    private void removeExtraSpace(StringBuilder sb) {
        for (int i =0;i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (i == 0 && c == ' ') {
                sb.deleteCharAt(0);
                --i;
            }
            if (sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length() - 1);
            }

            if (i > 0 && sb.charAt(i) == ' ' && sb.charAt(i - 1) == ' ') {
                sb.deleteCharAt(i);
                i--;
            }
        }
    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s);
        removeExtraSpace(sb);
        mirrorWord(sb);
        reverse(sb);
        return sb.toString();
    }

    private void reverse(StringBuilder sb) {
        for (int i =0; i < sb.length() / 2; i++) {
            char c = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(sb.length() - i -1));
            sb.setCharAt(sb.length() - i - 1, c);
        }
    }

    private void mirrorWord(StringBuilder sb) {
        for (int i =0; i < sb.length();) {
            if (sb.charAt(i) == ' ') {
                i++;
            }
            int j = i;
            while (j < sb.length() && sb.charAt(j) != ' ' ) {
                j++;
            }
            j--;

            int offset = i;
            for (int k = 0; k <= (j - i) / 2; k++) {
                char head = sb.charAt(offset + k);
                char tail = sb.charAt(j - k - i + offset);
                sb.setCharAt(offset + k, tail);
                sb.setCharAt(j - k, head);
            }
            i = j + 1;
        }
    }

    public static void main(String[] args) {
        String s = "  hello world  ";
        System.out.println("_" + new ReverseWords_151().reverseWords_1(s) + "_");
    }
}
