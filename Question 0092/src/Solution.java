class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Move to the node just before the reversal segment
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;
        ListNode next = null;

        // Reverse the sublist between left and right
        for (int i = left; i <= right; i++) {
            ListNode temp = curr.next;
            curr.next = next;
            next = curr;
            curr = temp;
        }

        // Connect the reversed sublist back to the original list
        prev.next.next = curr;
        prev.next = next;

        return left == 1 ? next : head;
    }
}
