import java.util.HashMap;
import java.util.Map;

class Solution
{
    public long countSubarrays(int[] nums, int k) {
        int left = 0, max = Integer.MIN_VALUE;
        long count = 0L;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++)
        {
            max = Math.max(max,nums[i]);
        }

        for(int right = 0; right < nums.length; right++)
        {
            map.put(nums[right], map.getOrDefault(nums[right],0)+1);

            while(map.getOrDefault(max,0) >= k)
            {
                count += nums.length - right;
                map.put(nums[left], map.get(nums[left])-1);
                left++;
            }
        }

        return count;
    }
}
