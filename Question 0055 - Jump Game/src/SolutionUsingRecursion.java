class SolutionUsingRecursion
{
    private boolean solve(int[] nums, int index, int jump)
    {
        //base case
        if(index == nums.length-1) return true;

        boolean ans = false;
        for(int i = 1; i <= jump; i++)
        {
            ans = ans || solve(nums, index+i, nums[index + i]);
        }

        return ans;
    }
    public boolean canJump(int[] nums)
    {
        return solve(nums,0, nums[0]);
    }
}