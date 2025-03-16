package dsa.stack;

import java.util.Stack;

public class RemoveDuplicates {
    public String removeDuplicates(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch: str.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            }
            else {
                stack.push(ch);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (char ch: stack) {
            sb.append(ch);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        
        var sol = new RemoveDuplicates();
        System.out.println(sol.removeDuplicates("azxxzy"));
    }
}
