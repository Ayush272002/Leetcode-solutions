import java.util.Arrays;

class TopDownApproach
{
    private int solve(int[] energy, int idx, int k, int[] dp)
    {
        //base case
        if(idx >= energy.length) return 0;
        if(dp[idx] != -1) return dp[idx];

        return dp[idx] = energy[idx] + solve(energy, idx+k, k, dp);
    }

    public int maximumEnergy(int[] energy, int k)
    {
        int ans = Integer.MIN_VALUE;
        int[] dp = new int[energy.length];
        Arrays.fill(dp, -1);

        for(int i = 0; i < energy.length; i++)
        {
            ans = Math.max(ans, solve(energy, i, k, dp));
        }

        return ans;
    }
}