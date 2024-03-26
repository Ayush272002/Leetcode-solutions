class SolutionUsingRecursion
{
    private int solve(int[] nums, int idx, int jump)
    {
        //base case
        if(idx >= nums.length -1) return 0;

        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= jump && i+idx < nums.length; i++)
        {
            int jmp = solve(nums,idx+i, nums[idx+i]);
            if(jmp != Integer.MAX_VALUE) ans = Math.min(ans, 1+ jmp);
        }

        return ans;
    }
    public int jump(int[] nums)
    {
        return solve(nums,0,nums[0]);
    }
}