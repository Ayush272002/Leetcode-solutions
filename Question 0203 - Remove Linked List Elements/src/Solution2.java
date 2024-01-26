class Solution2 {
    public ListNode removeElements(ListNode head, int val)
    {
        ListNode ans = new ListNode(-1);

        ListNode curr = head;
        ListNode temp = ans;

        while(curr != null)
        {
            if(curr.val != val)
            {
                temp.next = curr;
                temp = curr;
            }
            curr = curr.next;
        }
        temp.next = null;

        return ans.next;
    }
}