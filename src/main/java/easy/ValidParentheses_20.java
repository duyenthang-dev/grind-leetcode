package easy;

import java.util.Stack;

/**
 * Thuật toán:
 * Duyệt từ kí tự c của chuỗi
 * - nếu kí tự là dấu mở ngoặc thì đưa vào stack
 * - nêu kí tự là dấu đóng ngoặc thì có 2 trường hợp
 *      +, nếu stack rỗng -> false
 *      +, nếu stack k rỗng và top của stack là kí tự mở ngoặc tương ứng với c thì pop stack
 *      ngược lại -> false
 */

public class ValidParentheses_20 {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c== '[' ) {
                // open bracket
                st.push(c);
            }
            else {
                if (st.isEmpty())
                    return false;
                char top = st.peek();
                if (c == ')' && top == '('  || c == '}' && top == '{' || c == ']' && top == '[')
                    st.pop();
                else return false;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses_20().isValid("(]{}"));
    }
}
