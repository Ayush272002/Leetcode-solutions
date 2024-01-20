class Solution {
    public void deleteNode(ListNode node) {
        if(node.next == null)
            node = null;
        else
        {
            ListNode next = node.next;
            node.val = next.val;
            node.next = next.next;
            next.next = null;
        }
    }
}