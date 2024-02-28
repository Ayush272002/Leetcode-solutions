class Solution
{
    private int ans = 0;
    private int maxHeight = -1;

    private void dfs(TreeNode root, int height)
    {
        if(root == null) return;

        if(height > maxHeight)
        {
            ans = root.val;
            maxHeight = height;
        }

        dfs(root.left, height+1);
        dfs(root.right, height+1);
    }
   public int findBottomLeftValue(TreeNode root)
   {
       dfs(root,0);
       return ans;
   }
}
