class SolutionUsingRecursion
{
    private int solve(TreeNode root, boolean even)
    {
        //base case
        if(root == null) return 0;
        if(even)
        {
            int include = root.val + solve(root.right, !even) + solve(root.left, !even);
            int exclude = solve(root.right, even) + solve(root.left, even);
            return Math.max(include, exclude);

        }
        else
        {
            return solve(root.left, !even) + solve(root.right, !even);
        }
    }
    public int rob(TreeNode root)
    {
        boolean even = true;
        return solve(root, even);
    }
}