class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        int index =0;
        ListNode temp = head;
        while(temp != null)
        {
            index++;
            temp = temp.next;
        }

        index = index -n ;

        if(index ==0)
        {
            return head.next;
        }

        temp = head;
        ListNode prev = null;
        for(int i=0; i< index; i++)
        {
            prev = temp;
            temp = temp.next;
        }

        prev.next = temp.next;

        return head;
    }
}
