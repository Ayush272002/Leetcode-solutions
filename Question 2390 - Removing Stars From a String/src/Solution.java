import java.util.Stack;

class Solution {
    public String removeStars(String s)
    {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '*') st.pop();
            else st.push(s.charAt(i));
        }

        // Convert stack to a string
        StringBuilder result = new StringBuilder();
        for (Character ch : st) {
            result.append(ch);
        }
        return result.toString();

    }
}