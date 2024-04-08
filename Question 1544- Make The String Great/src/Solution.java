import java.util.Stack;

class Solution
{
    public String makeGood(String s)
    {
        Stack<Character> st = new Stack<>();

        int n = s.length();
        for(int i = 0; i < n; i++)
        {
            char c = s.charAt(i);
            if(!st.isEmpty() && Math.abs(st.peek()-c)==32) st.pop();
            else st.push(c);
        }

        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty())
        {
            ans.append(st.pop());
        }

        return ans.reverse().toString();

    }
}