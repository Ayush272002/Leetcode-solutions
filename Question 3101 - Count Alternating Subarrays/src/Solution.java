class Solution
{
    public long countAlternatingSubarrays(int[] nums)
    {
        long count = 1;

        int left = 0, right = 0;
        int n = nums.length;

        while(right < n -1)
        {
            if(nums[right] != nums[right + 1]) right++;
            else
            {
                left = right + 1;
                right++;
            }

            count += right - left + 1;
        }

        return count;
    }
}