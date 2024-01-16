public class OptimisedSol {
    private TreeNode converter(ListNode head, ListNode tail)
    {
        if(head == tail) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != tail && fast.next != tail)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = converter(head, slow);
        root.right = converter(slow.next, tail);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return converter(head, null);
    }
}
