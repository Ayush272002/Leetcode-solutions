class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //base case
        if(p == null && q == null) return true;
        if(p == null && q != null) return false;
        if(p != null && q == null) return false;

        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right , q.right);

        boolean value = p.val == q.val;

        return left && right && value;
    }
}