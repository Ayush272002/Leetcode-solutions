class Solution {
    public ListNode deleteDuplicates(ListNode head)
    {
       if(head == null) return head;

       ListNode curr = head;
       ListNode next = curr.next;


       ListNode ans = new ListNode(-1);
       ListNode ansPtr = ans;

       while(next != null)
       {
           if(curr.val == next.val)
           {
               while(next != null && curr.val == next.val)
               {
                   curr = next;
                   next = curr.next;
               }

               //move to the next non duplicate val
               curr = next;
               if(next != null) next = curr.next;
           }
           else
           {
               ansPtr.next = curr;
               ansPtr = curr;
               curr = curr.next;
               next = curr.next;
           }
       }

        // To handle the case where the last node is not a duplicate
       ansPtr.next = curr;

       return ans.next;
    }
}