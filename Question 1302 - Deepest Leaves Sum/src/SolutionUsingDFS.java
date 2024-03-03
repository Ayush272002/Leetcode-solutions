public class SolutionUsingDFS
{
    private int sum = 0;
    private int maxDepth = 0;
    private void dfs(TreeNode root, int depth)
    {
        if(root == null) return;

        if(depth > maxDepth)
        {
            maxDepth = depth;
            sum = 0;
        }

        if(depth == maxDepth) sum += root.val;

        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
    }
    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return sum;
    }
}
