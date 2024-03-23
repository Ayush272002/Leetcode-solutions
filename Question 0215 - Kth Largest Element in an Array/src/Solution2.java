import java.util.Arrays;

class Solution2 {
    public int findKthLargest(int[] nums, int k)
    {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}