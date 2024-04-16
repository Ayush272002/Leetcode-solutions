class Solution
{
    private int solve(TreeNode root, int val)
    {
        if(root == null) return 0;

        val = val * 10 + root.val;
        if(root.left == null && root.right == null) return val;
        return solve(root.left, val) + solve(root.right, val);

    }

    public int sumNumbers(TreeNode root)
    {
        return solve(root, 0);
    }
}