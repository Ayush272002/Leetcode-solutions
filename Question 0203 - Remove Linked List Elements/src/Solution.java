class Solution {
    public ListNode removeElements(ListNode head, int val)
    {
        if(head == null) return head;

        while (head != null && head.val == val)
        {
            head = head.next;
            if(head == null) return null;
        }

        ListNode curr = head;
        ListNode next = curr.next;

        while(curr.next != null)
        {
            if(next.val == val)
            {
                curr.next = next.next;
                next = curr.next;
            }

            else
            {
                curr= curr.next;
                next = curr.next;
            }
        }

        return head;
    }
}