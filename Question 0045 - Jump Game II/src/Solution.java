import java.util.Arrays;

class Solution
{
    private int solve(int[] nums, int idx, int jump, int[] dp)
    {
        //base case
        if(idx >= nums.length -1) return 0;
        if(dp[idx] != -1) return dp[idx];

        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= jump && i+idx < nums.length; i++)
        {
            int jmp = solve(nums,idx+i, nums[idx+i], dp);
            if(jmp != Integer.MAX_VALUE) ans = Math.min(ans, 1+ jmp);
        }

        return dp[idx] = ans;
    }
    public int jump(int[] nums)
    {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(nums,0,nums[0], dp);
    }
}