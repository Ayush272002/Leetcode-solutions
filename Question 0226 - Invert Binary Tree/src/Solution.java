class Solution {
    private void solve(TreeNode root) {
        if (root == null)
            return;

        TreeNode l = root.left;
        root.left = root.right;
        root.right = l;

        solve(root.left);
        solve(root.right);
    }

    public TreeNode invertTree(TreeNode root) {
        solve(root);
        return root;
    }
}