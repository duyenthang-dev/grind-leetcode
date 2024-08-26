package easy;

import java.util.Arrays;

public class LongestCommonPrefix_14 {
    // ý tưởng: chỉ quan tâm chuỗi dài nhất và ngắn nhất
    // ví dụ: {"ab", "a", "d"} -> {"a", "ab", "d"}
    // ta chỉ quan tâm "a" và "d",
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int idx = 0;
        while(idx < s1.length() && idx < s2.length()){
            if(s1.charAt(idx) == s2.charAt(idx)){
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }

    public static void main(String[] args) {
        String[] temp = new String[]{"ab", "a", "d"};
        System.out.println(new LongestCommonPrefix_14().longestCommonPrefix(temp));
    }
}
