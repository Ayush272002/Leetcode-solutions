class Solution {
    private boolean checkPath(ListNode head, TreeNode root)
    {
        //base case
        if(head == null) return true;
        if(root == null || head.val != root.val) return false;

        return checkPath(head.next, root.left) || checkPath(head.next, root.right);
    }
    public boolean isSubPath(ListNode head, TreeNode root)
    {
        if(head == null) return true;

        if(root == null) return false;

        return checkPath(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
}