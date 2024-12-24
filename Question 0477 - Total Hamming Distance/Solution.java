class Solution {
    public int totalHammingDistance(int[] nums) {
        int hammingD = 0;
        for (int i = 0; i < 32; i++) {
            int count1s = 0;
            for (int j = 0; j < nums.length; j++) {
                count1s += (nums[j] >>> i) & 1;
            }

            hammingD += (count1s) * (nums.length - count1s);
        }

        return hammingD;
    }
}