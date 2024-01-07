import java.util.HashMap;

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums[i] , map.getOrDefault(nums[i], 0)+1);
        }

        for (int i = 0; i < n; i++) {
            int count = map.get(nums[i]);
            if(count == 1) return nums[i];
        }
        return -1;
    }
}