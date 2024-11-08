import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];

            if (map.containsKey(x)) {
                ans[0] = i;
                ans[1] = map.get(x);
                return ans;
            }

            map.put(ans[i], i);
        }

        return ans;
    }
}