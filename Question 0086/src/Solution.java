class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(-1);
        ListNode small_pointer = small;

        ListNode big = new ListNode(-1);
        ListNode big_pointer = big;

        while(head != null)
        {
            if(head.val >= x)
            {
                big_pointer.next = head;
                big_pointer = big_pointer.next;
            }
            else
            {
                small_pointer.next = head;
                small_pointer = small_pointer.next;
            }
            head = head.next;
        }

        big_pointer.next = null;
        small_pointer.next = big.next;

        return small.next;
    }
}