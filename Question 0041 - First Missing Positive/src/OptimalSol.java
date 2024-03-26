class OptimalSol
{
    public int firstMissingPositive(int[] nums)
    {
        int i = 0;
        int n = nums.length;

        //cyclic sort
        while(i < n)
        {
            int indx = nums[i] - 1;

            //swap
            if(indx >= 0 && indx < n && nums[i] != nums[indx])
            {
                nums[i] = nums[i] ^ nums[indx];
                nums[indx] = nums[i] ^ nums[indx];
                nums[i] = nums[i] ^ nums[indx];
            }
            else i++;
        }


        //if i == nums[i] -1 fine otherwise return i+1, cause it will be of the form
        //[1,6,7,8,9] something like that
        for(i = 0; i < n; i++)
        {
            if(i != nums[i] -1) return i+1;
        }

        return n+1; //here the array will be of the form [1,2,3,4] so 4+1 = 5 thats ans
    }
}