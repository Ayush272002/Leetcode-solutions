import java.util.Arrays;

class TopDown
{
    final int MOD = 1000000007;

    private int solve(int zero, int one, int consecutiveEl, int count, int limit, int[][][][] dp)
    {
        if(zero == 0 && one == 0) return 1;
        if (dp[zero][one][consecutiveEl][count] != -1) return dp[zero][one][consecutiveEl][count];

        int ans = 0;
        if(zero > 0)
        {
            if(consecutiveEl == 0 && count < limit) ans = (ans + solve(zero-1, one, 0, count+1, limit, dp)) % MOD;
            else if(consecutiveEl == 1 || consecutiveEl == 2) ans = (ans + solve(zero-1, one, 0, 1, limit, dp)) % MOD;
        }

        if(one > 0)
        {
            if(consecutiveEl == 1 && count < limit) ans = (ans + solve(zero, one-1, 1, count+1, limit, dp)) % MOD;
            else if(consecutiveEl == 0 || consecutiveEl == 2) ans = (ans + solve(zero, one-1, 1, 1, limit, dp)) % MOD;
        }

        return dp[zero][one][consecutiveEl][count] = ans%MOD;
    }
    public int numberOfStableArrays(int zero, int one, int limit)
    {
        //2 for base case
        int[][][][] dp = new int[zero + 1][one + 1][3][limit + 1];
        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {
                for (int k = 0; k < 3; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }
        return (solve(zero, one, 2, 0, limit, dp) % MOD);
    }
}