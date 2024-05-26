import java.util.ArrayList;
import java.util.List;

class Solution
{
    private int solve(int[] nums, int k, List<Integer> list, int idx)
    {
        if(idx >= nums.length) return 0;

        //skip
        int skip = solve(nums, k, list, idx+1);

        boolean flag = true;
        for(int x : list)
        {
            if(Math.abs(x-nums[idx]) == k) flag = false;
        }

        int take = 0;
        if(flag)
        {
            list.add(nums[idx]);
            take = 1 + solve(nums, k, list, idx+1);
            list.remove(list.size()-1);
        }

        return take + skip;
    }
    public int beautifulSubsets(int[] nums, int k)
    {
        List<Integer> list = new ArrayList<>();
        return solve(nums, k, list, 0);
    }
}