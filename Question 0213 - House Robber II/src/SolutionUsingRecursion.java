class SolutionUsingRecursion
{
    private int solve(int[] nums,int start,  int end)
    {
        //base case
        if(end < start) return 0;
        if(end == start) return nums[start];

        int include = nums[end] + solve(nums,start, end-2);
        int exclude = solve(nums,start, end-1);


        return Math.max(include,exclude);
    }
    public int rob(int[] nums)
    {
        int n = nums.length;
        int ans1 = solve(nums,1,n-1);
        int ans2 = solve(nums,0,n-2);
        return Math.max(ans1,ans2);
    }
}