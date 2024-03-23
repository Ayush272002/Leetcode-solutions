class OptimisedSol {
    public int findDuplicate(int[] nums)
    {
        int fast = nums[0] , slow = nums[0];

        do
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while(fast != slow);

        //find the enterance to the cycle
        slow = nums[0];
        while(slow != fast)
        {
            fast = nums[fast];
            slow = nums[slow];
        }

        return fast;
    }
}