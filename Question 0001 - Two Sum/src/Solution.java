import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] copy = Arrays.copyOf(nums, n);

        int low = 0, high = n-1;
        int val1 = 0, val2 = 0;
        Arrays.sort(nums);

        int[] ans = new int[2];
        int sum;

        while(low <= high)
        {
            sum = nums[low] + nums[high];

            if(sum == target)
            {
                val1 = nums[low];
                val2 = nums[high];
                break;
            }
            else if(sum > target) high--;
            else low++;
        }

        for (int i = 0; i < copy.length; i++)
        {
            if (copy[i] == val1)
            {
                ans[0] = i;
                break;
            }
        }

        for (int i = 0; i < copy.length; i++)
        {
            if (i != ans[0] && copy[i] == val2)
            {
                ans[1] = i;
                break;
            }
        }

        return ans;
    }
}