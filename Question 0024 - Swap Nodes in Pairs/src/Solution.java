import java.util.Stack;

class Solution {
    public ListNode swapPairs(ListNode head)
    {
        ListNode dummy = new ListNode(-1);
        ListNode dummyPtr = dummy;
        Stack<ListNode> st = new Stack<>();

        ListNode ptr = head;

        while(ptr != null)
        {
            ListNode ptrNext = ptr.next;
            for (int i = 0; i < 2 && ptr!= null; i++) {
                st.push(ptr);
                ptr = ptrNext;
                if(ptrNext != null) ptrNext = ptrNext.next;
            }

            while(!st.isEmpty())
            {
                dummyPtr.next = st.pop();
                dummyPtr = dummyPtr.next;
            }

        }

        dummyPtr.next = null;
        return dummy.next;
    }
}