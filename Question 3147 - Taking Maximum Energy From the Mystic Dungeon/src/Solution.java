class Solution
{
    private int solve(int[] energy, int idx, int k, int sum)
    {
        //base case
        if(idx >= energy.length) return sum;

        sum += energy[idx];
        return solve(energy, idx+k, k, sum);
    }

    public int maximumEnergy(int[] energy, int k)
    {
        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < energy.length; i++)
        {
            ans = Math.max(ans, solve(energy, i, k, 0));
        }

        return ans;
    }
}