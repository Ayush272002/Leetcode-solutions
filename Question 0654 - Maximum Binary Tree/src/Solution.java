class Solution {
    private TreeNode solve(int[] nums, int start, int end) {
        // base case
        if (start > end)
            return null;

        int max = Integer.MIN_VALUE;
        int endIdx = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                endIdx = i;
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = solve(nums, start, endIdx - 1);
        root.right = solve(nums, endIdx + 1, end);
        return root;

    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return solve(nums, 0, nums.length - 1);

    }
}