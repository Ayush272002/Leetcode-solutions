import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        Arrays.sort(nums);
        int count = 1;
        int temp = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) temp++;
                else {
                    count = Math.max(count, temp);
                    temp = 1;
                }
            }
        }

        return Math.max(count, temp);
    }
}
