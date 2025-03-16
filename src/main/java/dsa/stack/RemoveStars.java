package dsa.stack;

import java.util.Stack;

public class RemoveStars {
    public String removeStars(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch: str.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() != '*' && ch == '*') {
                stack.pop();
            }
            else {
                stack.push(ch);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (char ch: stack) {
            if (ch != '*')
                sb.append(ch);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        var sol = new RemoveStars();
        System.out.println(sol.removeStars("*a*b*c*d*"));
    }
}
