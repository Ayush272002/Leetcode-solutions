class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxStraightSum = Integer.MIN_VALUE, minStraightSum = Integer.MAX_VALUE;
        int arraySum = 0;
        int tempMaxSum = 0, tempMinSum = 0;

        for (int i = 0; i < nums.length; i++) {
            arraySum += nums[i];

            tempMaxSum += nums[i];
            maxStraightSum = Math.max(tempMaxSum, maxStraightSum);
            if (tempMaxSum < 0)
                tempMaxSum = 0;

            tempMinSum += nums[i];
            minStraightSum = Math.min(tempMinSum, minStraightSum);
            if (tempMinSum > 0)
                tempMinSum = 0;
        }

        if (arraySum == minStraightSum)
            return maxStraightSum;

        else
            return Math.max(maxStraightSum, arraySum - minStraightSum);
    }
}