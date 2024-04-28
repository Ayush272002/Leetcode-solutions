 class BottomUpApproach
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
                for(int count = 1; count <= Math.min(z, limit); count++)
                    dp[z][o][0] = (dp[z-count][o][1] + dp[z][o][0]) % MOD;

                for(int count = 1; count <= Math.min(o, limit); count++)
                    dp[z][o][1] = (dp[z][o-count][0] + dp[z][o][1]) % MOD;
            }
        }

        return (dp[zero][one][0] + dp[zero][one][1]) % MOD;
    }
}