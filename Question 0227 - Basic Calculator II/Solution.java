import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int number = 0;
        char op = '+';

        for (int i = 0; i < s.length(); i++) {
            char val = s.charAt(i);
            if (Character.isDigit(val)) {
                number = (number * 10) + (val - '0');
            }

            if ((!Character.isDigit(val) && val != ' ') || (i == s.length() - 1)) {
                if (op == '+') {
                    st.push(number);
                } else if (op == '-') {
                    st.push(-1 * number);
                } else if (op == '*') {
                    st.push(number * st.pop());
                } else if (op == '/') {
                    st.push(st.pop() / number);
                }

                number = 0;
                op = val;
            }
        }

        int ans = 0;
        while(!st.isEmpty()) {
            ans += st.pop();
        }

        return ans;
    }
}