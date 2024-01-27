class Solution {
    public ListNode rotateRight(ListNode head, int k)
    {
        if(head == null) return head;
        if(k==0) return head;

        ListNode start = head;
        ListNode end = head;

        while (end.next != null)
        {
            end = end.next;
        }

        int length = 0;
        ListNode temp =  head;
        while (temp != null)
        {
            length++;
            temp = temp.next;
        }

        k = k%length;

        while(k != 0)
        {
            end.next = start;
            start = end;
            while (start != end.next)
            {
                end = end.next;
            }
            end.next = null;
            k--;
        }

        return start;
    }
}