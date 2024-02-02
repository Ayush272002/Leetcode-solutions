import java.util.Arrays;

class Solution {
    public int[][] divideArray(int[] nums, int k)
    {
        if(nums.length%3 != 0) return new int[0][0];

        Arrays.sort(nums);

        int[][] ans = new int[nums.length/3][3];
        int index = 0;

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < 3; j++) {
                ans[i][j] = nums[index++];
            }

            if(ans[i][2] - ans[i][0] > k) return new int[0][0];

        }

        return ans;
    }
}