class Solution {
    public int[] runningSum(int[] nums) {
        int[] sum = new int[nums.length];
        int runningTotal = nums[0];
        sum[0] = runningTotal;

        for (int i = 1; i < nums.length; i++) {
            runningTotal += nums[i];
            sum[i] = runningTotal;
        }
        return sum;
    }
}