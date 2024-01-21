class Solution {
    public TreeNode searchBST(TreeNode root, int val) {

        //base case
        if(root == null) return null;
        if(root.val == val) return root;

        //recursion
        if(val > root.val) return searchBST(root.right, val);
        else return searchBST(root.left, val);
    }
}