package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duyenthang
 * @since 2024-02-01
 * time spent: 24m
 */

public class ZigzagConversion_6 {
    public String convert(String s, int numRows) {
        List<StringBuilder> lst = new ArrayList<>();
        int direction = 1;
        int y = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = null;
            if (lst.size() > y)
                sb = lst.get(y);
            if (sb == null) {
                sb = new StringBuilder();
                lst.add(sb);
            }
            sb.append(s.charAt(i));
            lst.set(y, sb);
            if (y == 0) {
                direction = 1;
            }
            else if (y == numRows -1) {
                direction = -1;
            }
            y += direction;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder i: lst) {
            res.append(i);
        }
        return res.toString();
    }
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(new ZigzagConversion_6().convert(s, numRows));
    }
}
