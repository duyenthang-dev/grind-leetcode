package v1.easy;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RomanToInteger_13 {
    public int romanToInt(String s) {
        Map<Character, Integer> map = Stream.of(new Object[][] {
                {'M', 1000},
                {'D', 500},
                {'C', 100},
                {'L', 50},
                {'X', 10},
                {'V', 5},
                {'I', 1},
        }).collect(Collectors.toMap(pair -> (Character)pair[0], pair -> (Integer) pair[1]));
        int result = 0;
        int len = s.length();
        for (int i =0; i < len; i++) {
            char c = s.charAt(i);
            if (c == 'I' && i < len -1) {
                if (s.charAt(i + 1) == 'V') {
                    result += 4;
                    i++;
                }
                else if (s.charAt(i + 1) == 'X') {
                    result += 9;
                    i++;
                }
                else result += map.get(c);
            }
            else if (c == 'X' && i < len -1) {
                if (s.charAt(i + 1) == 'L') {
                    result += 40;
                    i++;
                }
                else if (s.charAt(i + 1) == 'C') {
                    result += 90;
                    i++;
                }
                else result += map.get(c);
            }
            else if (c == 'C' && i < len -1) {
                if (s.charAt(i + 1) == 'D') {
                    result += 400;
                    i++;
                }
                else if (s.charAt(i + 1) == 'M') {
                    result += 900;
                    i++;
                }
                else result += map.get(c);
            }
            else  result += map.get(c);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new RomanToInteger_13().romanToInt("MCMXCIV"));
    }
}
