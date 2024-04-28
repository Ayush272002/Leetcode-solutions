class SolutionUsingRecursion
{
    final int MOD = 1000000007;

    private int solve(int zero, int one, int consecutiveEl, int count, int limit)
    {
        if(zero == 0 && one == 0) return 1;

        int ans = 0;
        if(zero > 0)
        {
            if(consecutiveEl == 0 && count < limit) ans = (ans + solve(zero-1, one, 0, count+1, limit)) % MOD;
            else if(consecutiveEl == 1 || consecutiveEl == 2) ans = (ans + solve(zero-1, one, 0, 1, limit)) % MOD;
        }

        if(one > 0)
        {
            if(consecutiveEl == 1 && count < limit) ans = (ans + solve(zero, one-1, 1, count+1, limit)) % MOD;
            else if(consecutiveEl == 0 || consecutiveEl == 2) ans = (ans + solve(zero, one-1, 1, 1, limit)) % MOD;
        }

        return ans%MOD;
    }
    public int numberOfStableArrays(int zero, int one, int limit)
    {
        //2 for base case
        return (solve(zero, one, 2, 0, limit) % MOD);
    }
}