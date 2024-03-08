import java.util.Arrays;

class TopDownApproach
{
    private int solve(int n, int[] dp)
    {
        //base case
        if(n < 0) return 0;
        if(n == 0 || n == 1) return 1;
        if(dp[n] != -1) return dp[n];

        int one = solve(n-1, dp);
        int two = solve(n-2, dp);

        dp[n] = one + two;
        return dp[n];
    }

    public int climbStairs(int n)
    {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n, dp);
    }
}