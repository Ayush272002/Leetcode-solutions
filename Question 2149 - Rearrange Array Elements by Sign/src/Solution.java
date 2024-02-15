import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] rearrangeArray(int[] nums)
    {
        Queue<Integer> pos = new LinkedList<>();
        Queue<Integer> neg = new LinkedList<>();

        for(int i : nums)
        {
            if(i>=0) pos.add(i);
            else neg.add(i);
        }

        int[] ans = new int[nums.length];
        int i =0;
        while(!pos.isEmpty() || !neg.isEmpty())
        {
            if(!pos.isEmpty())
            {
                ans[i] = pos.poll();
                i++;
            }
            if(!neg.isEmpty())
            {
                ans[i] = neg.poll();
                i++;
            }
        }
        return ans;
    }
}