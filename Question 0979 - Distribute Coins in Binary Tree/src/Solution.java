class Solution
{
    int moves;
    private int solve(TreeNode root)
    {
        if(root == null) return 0;
        int left = solve(root.left);
        int right = solve(root.right);

        moves += Math.abs(left) + Math.abs(right);
        return (root.val - 1) + left + right;
    }

    public int distributeCoins(TreeNode root)
    {
        moves = 0;
        solve(root);
        return moves;
    }
}