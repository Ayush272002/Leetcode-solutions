class Solution
{
    private int getSize(ListNode head)
    {
        if(head == null) return 0;

        ListNode temp = head;
        int size = 0;

        while(temp != null)
        {
            size++;
            temp = temp.next;
        }

        return size;
    }
    public ListNode swapNodes(ListNode head, int k)
    {
       ListNode firstPtr = head;
       ListNode lastPtr = head;

       int size = getSize(head);

        for (int i = 1; i < k; i++) {
            firstPtr = firstPtr.next;
        }

        for (int i = 0; i < size - k; i++) {
            lastPtr = lastPtr.next;
        }

        int temp = firstPtr.val;;
        firstPtr.val = lastPtr.val;;
        lastPtr.val = temp;


        return head;
    }
}