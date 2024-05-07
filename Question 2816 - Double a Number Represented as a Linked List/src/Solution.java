class Solution
{
    private int solve(ListNode head)
    {
        if(head == null) return 0;

        int sum = solve(head.next) + (head.val * 2);
        head.val = sum%10;
        return sum/10;
    }

    public ListNode doubleIt(ListNode head)
    {
        int carry = solve(head);
        return carry == 0 ? head : new ListNode(carry, head);
    }
}