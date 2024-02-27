class Solution2
{
    int maxD;
    private int solve(TreeNode root)
    {
        if(root == null) return 0;

        int left = solve(root.left);
        int right = solve(root.right);

        int d = left+right;

        maxD = Math.max(maxD,d);
        return Math.max(left,right)+1;
    }
    public int diameterOfBinaryTree(TreeNode root)
    {
        maxD = 0;
        solve(root);
        return maxD;
    }
}