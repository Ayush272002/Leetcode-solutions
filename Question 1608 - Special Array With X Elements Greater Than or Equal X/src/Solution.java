import java.util.Arrays;

class Solution
{
    private int solve(int[] nums, int i)
    {
        int s = 0, e = nums.length - 1, first = nums.length;
        while(s <= e)
        {
            int mid = s + (e-s)/2;

            if(nums[mid] >= i)
            {
                first = mid;
                e = mid-1;
            }
            else s = mid + 1;
        }

        return nums.length - first;
    }

    public int specialArray(int[] nums)
    {
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 1; i <= n; i++)
        {
            if(i == solve(nums, i)) return i;
        }

        return -1;
    }
}