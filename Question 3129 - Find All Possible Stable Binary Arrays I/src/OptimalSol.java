class OptimalSol
{
    final int MOD = 1000000007;
    public int numberOfStableArrays(int zero, int one, int limit)
    {
        int[][][] dp = new int[zero + 1][one + 1][3];

        for(int z = 0; z <= Math.min(zero, limit); z++) dp[z][0][0] = 1;
        for(int o = 0; o <= Math.min(one, limit); o++) dp[0][o][1] = 1;

        for(int z = 1; z <= zero; z++)
        {
            for(int o = 1; o <= one; o++)
            {
                dp[z][o][0] = (dp[z-1][o][0] + dp[z-1][o][1]) % MOD;
                dp[z][o][1] = (dp[z][o-1][0] + dp[z][o-1][1]) % MOD;

                if(z > limit) dp[z][o][0] = (dp[z][o][0] - dp[z-limit-1][o][1] + MOD) % MOD;
                if(o > limit) dp[z][o][1] = (dp[z][o][1] - dp[z][o-limit-1][0] + MOD) % MOD;
            }
        }

        return (dp[zero][one][0] + dp[zero][one][1]) % MOD;
    }
}