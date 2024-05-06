class Solution
{
    private ListNode rev(ListNode curr, ListNode prev)
    {
        if(curr == null) return prev;

        ListNode nxt = curr.next;
        curr.next = prev;
        return rev(nxt, curr);
    }

    public ListNode removeNodes(ListNode head)
    {
        head = rev(head, null);

        ListNode curr = head;
        ListNode maxi = head;

        while(curr != null && curr.next != null)
        {
            if(curr.next.val < maxi.val)
            {
                ListNode tmp = curr.next;
                curr.next = tmp.next;
                tmp.next = null;
            }
            else
            {
                maxi = curr.next;
                curr = curr.next;
            }
        }

        return rev(head, null);
    }
}