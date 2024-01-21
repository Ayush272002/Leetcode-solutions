class Solution {
    private int countNodes(TreeNode root)
    {
        if(root == null) return 0;

        return 1+countNodes(root.left) + countNodes(root.right);
    }

    private boolean isCBT(TreeNode root, int index, int count)
    {
        if(root == null) return true;

        if(index >= count) return false;
        else
        {
            boolean left = isCBT(root.left, 2*index + 1, count);
            boolean right = isCBT(root.right, 2*index + 2, count);
            return left && right;
        }
    }
    public boolean isCompleteTree(TreeNode root) {
        int index = 0;
        int totalCount = countNodes(root);
        return isCBT(root, index, totalCount);
    }
}