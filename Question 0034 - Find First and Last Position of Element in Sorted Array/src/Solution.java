class Solution {
    public int[] searchRange(int[] nums, int target)
    {
        int start = 0;
        int end = nums.length-1;

        int mid = start + (end-start)/2 ;

        int first = -1, last = -1;
        while (start <= end)
        {
            if(nums[mid] == target)
            {
                first = mid;
                end = end-1;
            }
            else if(target > nums[mid]) start = mid+1;
            else end = mid-1;

            mid = start + (end-start)/2 ;
        }

        start = 0;
        end = nums.length-1;
        mid = start + (end-start)/2 ;

        while (start <= end)
        {
            if(nums[mid] == target)
            {
                last = mid;
                start = start+1;
            }
            else if(target > nums[mid]) start = mid+1;
            else end = mid-1;

            mid = start + (end-start)/2 ;
        }

        return new int[]{first,last};
    }
}