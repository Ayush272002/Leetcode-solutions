class Solution {
    boolean sum(TreeNode root, int currSum, int targetSum)
    {
        if(root == null) return false;

        currSum = currSum + root.val;

        if(root.left == null && root.right == null) return currSum == targetSum;

        boolean left = sum(root.left , currSum , targetSum);
        boolean right = sum(root.right, currSum, targetSum);

        return left || right;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        return sum(root,0 ,targetSum);
    }
}