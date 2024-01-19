class Solution {

    private int calcSize(ListNode head)
    {
        ListNode temp = head;
        int count = 0;
        if(head == null) return count;

        while(temp != null)
        {
            temp = temp.next;
            count++;
        }

        return count;
    }

    private int getAtPos(ListNode head, int index)
    {
        ListNode temp = head;
        if(head == null) return -1;

        while (temp != null) {
            if (index == 0)
                return temp.val;

            temp = temp.next;
            index--;
        }

        return -1;
    }
    private TreeNode converter(ListNode head, int start, int end)
    {
        if(start > end) return null;

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(getAtPos(head, mid));
        root.left = converter(head, start, mid-1);
        root.right = converter(head,mid+1, end);

        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        int size = calcSize(head);
        if(head == null) return null;
        else return converter(head, 0, size-1);
    }
}