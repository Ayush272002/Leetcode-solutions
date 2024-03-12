import java.util.HashMap;
import java.util.Map;

class Solution
{
    public ListNode removeZeroSumSublists(ListNode head)
    {
        Map<Integer, ListNode> sum = new HashMap<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int prefixSum = 0;
        sum.put(prefixSum,dummy);

        while(head != null)
        {
            prefixSum += head.val;
            sum.put(prefixSum,head);
            head = head.next;
        }

        head = dummy;
        prefixSum = 0;

        while(head != null)
        {
            prefixSum += head.val;
            head.next = sum.get(prefixSum).next;
            head = head.next;
        }

        return dummy.next;
    }
}