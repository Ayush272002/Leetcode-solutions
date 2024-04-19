import java.util.ArrayDeque;

class Solution
{
    public long numberOfSubarrays(int[] nums)
    {
        ArrayDeque<int[]> st = new ArrayDeque<>();

        long ans = 0;

        for(int num : nums)
        {
            while(!st.isEmpty() && st.peek()[0] < num) st.pop();
            if(st.isEmpty() || st.peek()[0] != num) st.push(new int[]{num,0});
            if(st.peek() != null) ans += ++st.peek()[1];
        }

        return ans;
    }
}