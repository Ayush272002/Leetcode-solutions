import java.util.Arrays;

class Solution {
    public long largestPerimeter(int[] nums)
    {
        if(nums.length < 2) return -1; //not possible
        Arrays.sort(nums);

        long sum = 0;
        for(int i : nums) sum += i;

        for(int i = nums.length-1; i>=2; i--)
        {
            if(sum - nums[i] > nums[i]) return sum;
            sum -= nums[i];
        }
        return -1;
    }
}