import java.util.HashMap;
import java.util.Map;

class Solution
{
    private int solve(int[] nums, int k)
    {
        int left = 0, count = 0;
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();

        for(int right = 0; right < n; right++)
        {
            map.put(nums[right], map.getOrDefault(nums[right],0) + 1);

            while(map.size() > k)
            {
                map.put(nums[left], map.get(nums[left]) -1);
                if(map.get(nums[left]) == 0) map.remove(nums[left]);
                left++;
            }

            count += right-left+1;
        }

        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k)
    {
        return solve(nums,k) - solve(nums,k-1);
    }
}