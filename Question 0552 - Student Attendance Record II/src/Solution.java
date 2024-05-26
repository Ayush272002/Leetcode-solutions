import java.util.Arrays;

class Solution
{
    int MOD = 1000000007;
    private int solve(int n, int abs, int late, int[][][] dp)
    {
        if(n == 0) return 1;
        if(dp[n][abs][late] != -1) return dp[n][abs][late];

        int ans = 0;

        //present
        ans += solve(n-1, abs, 0, dp);
        ans %= MOD;

        //abs
        if(abs == 0)
        {
            ans += solve(n-1, abs+1, 0, dp);
            ans %= MOD;
        }


        //late
        if(late < 2)
        {
            ans += solve(n-1, abs, late+1, dp);
            ans %= MOD;
        }

        return dp[n][abs][late] = ans;
    }

    public int checkRecord(int n)
    {
        int[][][] dp = new int[n+1][2][3];
        Arrays.stream(dp).forEach(twoDArray -> Arrays.stream(twoDArray).forEach(oneDArray -> Arrays.fill(oneDArray, -1)));

        return solve(n, 0, 0, dp) % MOD;
    }
}