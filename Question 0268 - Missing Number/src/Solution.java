class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int num = 0;
        for (int no : nums) {
            num ^= no;
        }

        for (int i = 0; i <= n; i++)
            num ^= i;
        return num;
    }
}