class Solution
{
    private int solve(int[] nums, int idx, int ans)
    {
        if(idx >= nums.length) return ans;

        //take
        int take = solve(nums, idx+1, ans^nums[idx]);

        //skip
        int skip = solve(nums, idx+1, ans);
        return take + skip;
    }
    public int subsetXORSum(int[] nums)
    {
        return solve(nums, 0, 0);
    }
}