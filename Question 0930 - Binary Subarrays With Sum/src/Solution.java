class Solution
{
    private int atmostGoal(int[] nums, int goal)
    {
        int sum = 0;
        int count = 0;
        int start = 0;
        for (int end = 0; end < nums.length; end++)
        {
            sum += nums[end];
            while(sum > goal && start <= end)
            {
                sum -= nums[start];
                start++;
            }

            count += end - start + 1;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal)
    {
        // number of subarrays with atmost goal - number of subarrays with atmost goal -1
        // will give the exact number of subArrays
        return atmostGoal(nums,goal) - atmostGoal(nums,goal-1);
    }
}