class OptimisedSol
{
    public long countSubarrays(int[] nums, int k) {
        long ans = 0;
        int max = 0, count = 0, n = nums.length;
        for (int num : nums)
        {
            max = Math.max(max, num);
        }


        int left = 0;
        for (int right = 0; right < n; right++)
        {
            if (nums[right] == max) count++;
            while (count >= k)
            {
                ans += n - right;
                if (nums[left] == max) count--;
                left++;
            }
        }
        return ans;
    }
}