class OptimisedSol {
    public void sortColors(int[] nums)
    {
        int n = nums.length-1;
        int i = 0, p = 0;
        while(i <= n)
        {
            if(nums[i] == 2)
            {
                int temp = nums[n];
                nums[n] = 2;
                nums[i] = temp;
                n--;
            }
            else if(nums[i] == 0)
            {
                int temp = nums[p];
                nums[p] = 0;
                nums[i] = temp;
                p++;
                i++;
            }
            else i++;
        }
    }
}