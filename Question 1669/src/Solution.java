class Solution {
    int getSize(ListNode head)
    {
        ListNode temp = head;
        int sz =0;
        while(temp !=null)
        {
            temp = temp.next;
            sz++;
        }
        return sz;
    }
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        if(!(1<=a && a<=b && b<getSize(list1)-1)) return list1;

        ListNode temp = list1;

        for (int i = 0; i < a - 1; i++) {
            temp = temp.next;
        }

        ListNode temp2 = list1;

        for (int i = 0; i < b ; i++) {
            temp2 = temp2.next;
        }

        temp.next =  list2;
        while (list2.next != null) list2=list2.next;

        list2.next = temp2.next;
        temp2.next = null;

        return list1;

    }
}