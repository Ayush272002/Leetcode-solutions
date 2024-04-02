class Solution
{
    public long countSubarrays(int[] nums, int minK, int maxK)
    {
        int left = 0, n = nums.length, maxPtr = -1, minPtr = -1;
        long count = 0L;

        for(int right = 0; right < n; right++)
        {
            if(nums[right] > maxK || nums[right] < minK)
            {
                left = right + 1;
                continue;
            }

            if(nums[right] == maxK) maxPtr = right;
            if(nums[right] == minK) minPtr = right; // not else if bcz it will fail when maxK = minK

            //bounded
            count += Math.max(Math.min(maxPtr, minPtr) - left + 1, 0);
        }

        return count;
    }
}