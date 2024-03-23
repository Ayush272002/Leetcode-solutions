class Solution2
{
    private ListNode rev(ListNode curr, ListNode prev)
    {
        if(curr == null) return prev;

        ListNode tmp = curr.next;
        curr.next = prev;
        return rev(tmp,curr);
    }
    public void reorderList(ListNode head)
    {
        //find middle
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        //rev middle
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode middle = rev(tmp, null);


        //merge
        slow = head;
        while(middle != null)
        {
            ListNode nxt = slow.next;
            slow.next = middle;
            middle = middle.next;
            slow.next.next = nxt;
            slow = nxt;
        }

    }
}