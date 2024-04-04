import java.util.Stack;

class Solution
{
    public int lengthLongestPath(String input)
    {
        int count = 0;
        Stack<Integer> st = new Stack<>();
        String[] dir = input.split("\n");

        st.push(0);

        for(String d : dir)
        {
            int lv = d.lastIndexOf("\t") + 1;

            while(st.size() > lv + 1)
            {
                st.pop();
            }

            int len = st.peek() + d.length() - lv + 1;
            st.push(len);

            if(d.contains(".")) count = Math.max(count, len-1);
        }

        return count;
    }
}