class Solution
{
    private boolean solve(TreeNode root)
    {
        //base case -> leaf node either T or F
        if(root.left == null && root.right == null)
        {
            if(root.val == 0) return false;
            else return true;
        }

        if(root.val == 2) return (solve(root.left) | solve(root.right));
        else return (solve(root.left) & solve(root.right));
    }

    public boolean evaluateTree(TreeNode root)
    {
        return solve(root);
    }
}