public class Solution1 {
    private boolean isBST(TreeNode root, long min, long max)
    {
        //base case
        if(root == null) return true;

        if(root.val > min && root.val < max)
        {
            boolean left = isBST(root.left, min, root.val);
            boolean right = isBST(root.right, root.val, max);

            return left && right;
        }
        else return false;
    }

    public boolean isValidBST(TreeNode root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
