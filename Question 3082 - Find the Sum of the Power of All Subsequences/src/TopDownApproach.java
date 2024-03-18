import java.util.Arrays;

class TopDownApproach
{
    int mod = (int) 1e9 + 7;
    private long solve(int[] nums, int sum, int index, long[][] dp)
    {
        if(index == nums.length) return sum == 0 ? 1 : 0;
        if(sum < 0) return 0;
        if(dp[sum][index] != -1) return dp[sum][index];

        long ans = 0;
        //take curr element
        ans += solve(nums, sum- nums[index], index+1, dp);

        //skip
        ans += solve(nums, sum, index+1, dp)*2;

        if(ans >= mod) ans%=mod;
        return dp[sum][index] = ans;
    }
    public int sumOfPower(int[] nums, int k)
    {
        long[][] dp = new long[k+1][nums.length];
        Arrays.stream(dp).forEach(r->Arrays.fill(r,-1));
        return (int) solve(nums,k,0, dp);
    }
}