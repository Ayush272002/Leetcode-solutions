class SolutionUsingRecursion
{
    int mod = (int) 1e9 + 7;
    private long solve(int[] nums, int sum, int index)
    {
        if(index == nums.length) return sum == 0 ? 1 : 0;
        if(sum < 0) return 0;

        long ans = 0;
        //take curr element
        ans += solve(nums, sum- nums[index], index+1);

        //skip
        ans += solve(nums, sum, index+1)*2;

        if(ans >= mod) ans%=mod;
        return ans;
    }
    public int sumOfPower(int[] nums, int k)
    {
        return (int) solve(nums,k,0);
    }
}