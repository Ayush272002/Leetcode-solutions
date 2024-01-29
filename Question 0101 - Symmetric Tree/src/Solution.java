class Solution
{
    private boolean solve(TreeNode root1, TreeNode root2)
    {
        if(root1 == null && root2 == null) return true;
        if(root1 != null && root2 == null) return false;
        if(root1 == null && root2 != null) return false;

        boolean left = solve(root1.left, root2.right);
        boolean right = solve(root1.right, root2.left);

        return(root1.val == root2.val && left && right);
    }
    public boolean isSymmetric(TreeNode root)
    {
        if(root == null) return true;
        return solve(root.left, root.right);
    }
}