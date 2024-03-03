class OptimisedSol {
    public int[] sortedSquares(int[] nums)
    {
        int left = 0, right = nums.length-1;
        int[] ans = new int[right+1];
        int index = right;

        while(right >= left)
        {
            if(Math.abs(nums[right]) > Math.abs(nums[left]))
            {
                ans[index] = nums[right] * nums[right];
                right--;
            }
            else
            {
                ans[index] = nums[left] * nums[left];
                left++;
            }

            index--;
        }

        return ans;
    }
}