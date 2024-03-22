class Solution
{
    private ListNode solve(ListNode curr, ListNode prev)
    {
        if(curr == null) return prev;
        ListNode nxt = curr.next;
        curr.next = prev;
        return solve(nxt,curr);
    }
    public ListNode reverseList(ListNode head)
    {
        return solve(head,null);
    }
}