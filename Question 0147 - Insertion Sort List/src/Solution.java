class Solution
{
    public ListNode insertionSortList(ListNode head)
    {
        if(head == null || head.next == null) return head;

        ListNode ans = new ListNode(-1);
        ListNode curr = head;

        while(curr != null)
        {
            ListNode prev = ans, next = curr.next;

            while(prev.next != null && prev.next.val < curr.val) prev = prev.next;

            curr.next = prev.next;
            prev.next = curr;

            curr = next;
        }

        return ans.next;
    }
}