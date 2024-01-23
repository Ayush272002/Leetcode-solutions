import java.util.PriorityQueue;

class Solution2 {
    public ListNode sortList(ListNode head) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        ListNode ptr = head;
        while (ptr != null)
        {
            pq.add(ptr.val);
            ptr = ptr.next;
        }

        ListNode ans = new ListNode(-1);
        ptr = ans;

        while(!pq.isEmpty())
        {
            ListNode temp = new ListNode(pq.poll());
            ptr.next = temp;
            ptr = temp;
        }
        return ans.next;
    }
}