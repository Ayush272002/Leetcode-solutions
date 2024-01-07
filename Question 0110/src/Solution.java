class Solution {
    private int height(TreeNode node)
    {
        if(node == null) return 0;

        int left = height(node.left);
        int right = height(node.right);

        return Math.max(left,right) +1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);

        boolean difference =Math.abs(height(root.left) - height(root.right)) <=1 ;


        return left && right && difference;
    }
}