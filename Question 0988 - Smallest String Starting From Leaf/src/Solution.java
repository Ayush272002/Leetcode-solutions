class Solution
{
    private String str;

    private void dfs(TreeNode root, StringBuilder curr)
    {
        if(root == null) return;

        curr.insert(0, (char) ('a' + root.val));
        if(root.left == null && root.right == null)
        {
            if(str == null || curr.toString().compareTo(str) < 0)
                str = curr.toString();
        }
        else
        {
            dfs(root.left, curr);
            dfs(root.right, curr);
        }

        curr.deleteCharAt(0);
    }

    public String smallestFromLeaf(TreeNode root)
    {
        str = null;
        dfs(root, new StringBuilder());
        return str;
    }
}