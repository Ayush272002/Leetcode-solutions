class Solution {
    private int[] diameterAndHeight(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0}; // {diameter, height}
        }

        int[] leftResult = diameterAndHeight(node.left);
        int[] rightResult = diameterAndHeight(node.right);

        int height = 1 + Math.max(leftResult[1], rightResult[1]);
        int diameterThroughRoot = leftResult[1] + rightResult[1] ;
        int diameter = Math.max(Math.max(leftResult[0], rightResult[0]), diameterThroughRoot);

        return new int[]{diameter, height};
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return diameterAndHeight(root)[0];
    }
}