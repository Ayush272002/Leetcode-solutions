import java.util.Stack;

class Solution
{
    public String removeKdigits(String num, int k)
    {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < num.length(); i++)
        {
            while(!st.isEmpty() && st.peek() > num.charAt(i) && k > 0)
            {
                st.pop();
                k--;
            }

            st.push(num.charAt(i));
        }

        //remove remaining
        while(k > 0 && !st.isEmpty())
        {
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) sb.append(st.pop());

        sb.reverse();

        //remove leading zeros
        while(sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);

        return sb.isEmpty() ? "0" : sb.toString();
    }
}