class Solution2
{
    public int maxProduct(int[] nums)
    {
        int n = nums.length;
        int product = 1, maxi = nums[0];

        for (int i = 0; i < n; i++)
        {
            product *= nums[i];
            maxi = Math.max(product,maxi);
            if(product == 0) product = 1;
        }

        product = 1;
        for(int i = n-1; i >= 0; i--)
        {
            product *= nums[i];
            maxi = Math.max(product,maxi);
            if(product == 0) product = 1;
        }

        return maxi;
    }
}