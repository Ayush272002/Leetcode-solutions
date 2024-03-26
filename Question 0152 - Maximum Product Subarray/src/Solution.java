class Solution
{
    public int maxProduct(int[] nums)
    {
        int maxP = nums[0], minP = nums[0], ans = nums[0];

        for(int i = 1; i < nums.length; i++)
        {
            int x = maxP;
            maxP = Math.max(nums[i], Math.max(x*nums[i], minP*nums[i]));
            minP = Math.min(nums[i], Math.min(x*nums[i], minP*nums[i]));
            ans = Math.max(ans,maxP);
        }

        return ans;

    }
}