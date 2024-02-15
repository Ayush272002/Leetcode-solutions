class Solution {
    public void reorderList(ListNode head)
    {
        if(head == null || head.next == null) return;

       //middle element
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        //reversing the second half
        ListNode rev = reverse(slow.next);
        slow.next = null;

        //merging
        ListNode curr = head;
        ListNode revPtr = rev;

        while(curr != null && revPtr != null)
        {
            ListNode temp = curr.next;
            curr.next = revPtr;
            ListNode temp2 = revPtr.next;

            revPtr.next = temp;
            curr = temp;
            revPtr = temp2;
        }
    }

    private ListNode reverse(ListNode node)
    {
        ListNode prev = null;
        ListNode curr = node;
        ListNode next = null;

        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}