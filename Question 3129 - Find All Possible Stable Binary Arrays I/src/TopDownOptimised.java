import java.util.Arrays;

class TopDownOptimised
{
    final int MOD = 1000000007;

    private int solve(int zero, int one, int consecutiveEl, int limit, int[][][] dp)
    {
        if(zero == 0 && one == 0) return 1;
        if (dp[zero][one][consecutiveEl] != -1) return dp[zero][one][consecutiveEl];

        int ans = 0;
        if(consecutiveEl != 0)
        {
            for(int count = 1; count <= Math.min(zero, limit); count++)
                ans = (ans + solve(zero-count, one, 0, limit, dp)) % MOD;
        }

        if(consecutiveEl != 1)
        {
            for(int count = 1; count <= Math.min(one, limit); count++)
                ans = (ans + solve(zero, one-count, 1, limit, dp)) % MOD;
        }

        return dp[zero][one][consecutiveEl] = ans%MOD;
    }
    public int numberOfStableArrays(int zero, int one, int limit)
    {
        //2 for base case
        int[][][] dp = new int[zero + 1][one + 1][3];
        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return (solve(zero, one, 2,  limit, dp) % MOD);
    }
}