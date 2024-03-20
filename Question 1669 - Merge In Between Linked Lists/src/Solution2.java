class Solution2 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2)
    {
        ListNode ptr = list1;
        for(int i = 1; i < a; i++) ptr = ptr.next;

        ListNode ptr2 = list1;
        for (int i = 1; i <= b; i++) {
            ptr2 = ptr2.next;
        }

        ListNode ptr3 = list2;
        while(ptr3.next != null) ptr3 = ptr3.next;
        ptr.next = list2;
        ptr3.next = ptr2;
        return list1;
    }
}