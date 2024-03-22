class Solution3
{
    private ListNode reverse(ListNode curr, ListNode prev)
    {
        if(curr == null) return prev;
        ListNode tmp = curr.next;
        curr.next = prev;
        return reverse(tmp,curr);
    }
    public boolean isPalindrome(ListNode head)
    {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rev = reverse(slow, null);
        ListNode temp = head;
        while(rev!= null && temp != null)
        {
            if(rev.val != temp.val) return false;
            rev = rev.next;
            temp = temp.next;
        }

        return true;
    }
}