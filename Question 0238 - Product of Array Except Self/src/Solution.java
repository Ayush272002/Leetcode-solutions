class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int[] l_arr = new int[nums.length];
        int[] r_arr = new int[nums.length];

        int l_mult = 1, r_mult = 1;
        for (int i = 0; i < nums.length; i++) {
            l_arr[i] = l_mult;
            l_mult *= nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            r_arr[i] = r_mult;
            r_mult *= nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            ans[i] = l_arr[i] * r_arr[i];
        }

        return ans;
    }
}