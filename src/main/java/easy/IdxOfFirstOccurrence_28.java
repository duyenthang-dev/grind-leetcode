package easy;

public class IdxOfFirstOccurrence_28 {
    static int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean ok = true;
                for (int j = 1; j < needle.length(); j++) {
                    if (i + j >= haystack.length()) {
                        ok = false;
                        break;
                    }
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        ok = false;
                        break;
                    }
                }
                if (ok)
                    return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "aaa";
        String needle = "aaaa";
        System.out.println(strStr(haystack, needle));
    }
}
