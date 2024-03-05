import java.util.Arrays;

class Solution
{
    private int solve(int[] nums,int start,  int end, int[] dp)
    {
        //base case
        if(end < start) return 0;
        if(end == start) return nums[start];
        if(dp[end] != -1) return dp[end];

        int include = nums[end] + solve(nums,start, end-2, dp);
        int exclude = solve(nums,start, end-1, dp);

        dp[end] = Math.max(include,exclude);
        return dp[end];
    }
    public int rob(int[] nums)
    {
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];

        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        int ans1 = solve(nums,1,n-1,dp);

        Arrays.fill(dp,-1);
        int ans2 = solve(nums,0,n-2,dp);
        return Math.max(ans1,ans2);
    }
}