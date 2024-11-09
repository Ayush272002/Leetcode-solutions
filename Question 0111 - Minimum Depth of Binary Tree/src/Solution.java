class Solution {
    int min = Integer.MAX_VALUE;

    private void solve(TreeNode root, int curr) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            min = Integer.min(curr, min);
            return;
        }

        solve(root.left, curr + 1);
        solve(root.right, curr + 1);
    }

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        solve(root, 1);
        return min;
    }
}