class TopDownApproach
{
    private boolean solve(int[] nums, int index, int jump, Boolean[] dp)
    {
        //base case
        if(index == nums.length-1) return true;
        if(dp[index] != null) return dp[index];

        boolean ans = false;
        for(int i = 1; i <= jump; i++)
        {
            ans = ans || solve(nums, index+i, nums[index + i], dp);
        }

        return dp[index] = ans;
    }
    public boolean canJump(int[] nums)
    {
        Boolean[] dp = new Boolean[nums.length];
        return solve(nums,0, nums[0], dp);
    }
}