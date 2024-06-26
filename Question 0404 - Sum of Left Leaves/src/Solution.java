class Solution
{
    public int sumOfLeftLeaves(TreeNode root)
    {
        if(root == null) return 0;

        int ans = 0;
        if(root.left != null && root.left.left == null && root.left.right == null) ans += root.left.val;

        ans += sumOfLeftLeaves(root.left);
        ans += sumOfLeftLeaves(root.right);
        return ans;
    }
}