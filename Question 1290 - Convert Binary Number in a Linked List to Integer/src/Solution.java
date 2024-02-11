class Solution {
    public int getDecimalValue(ListNode head)
    {
        ListNode ptr = head;
        int ans = 0;

        while (ptr != null)
        {
            ans = ans * 2 + ptr.val;
            ptr = ptr.next;
        }

        return ans;
    }
}