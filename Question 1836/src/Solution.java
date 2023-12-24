import java.util.HashMap;
import java.util.Map;

public class Solution {

    ListNode head;

    public void print()
    {
        ListNode temp = head;
        if(head == null)
        {
            System.out.println("List is empty");
            return;
        }
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void insertAtStart(int data)
    {
        ListNode temp = new ListNode(data);
        temp.next = head;
        head = temp;
    }
    void insertAtEnd(int data)
    {
        ListNode node = new ListNode(data);

        if(head == null)
            head = node;

        else
        {
            ListNode temp = head;
            while(temp.next != null)
                temp = temp.next;

            temp.next = node;
        }
    }

    public void deleteUsingValue(int data) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null && curr.data != data) {
            prev = curr;
            curr = curr.next;
        }

        if (curr != null) {
            // Update prev.next to skip the node to be deleted
            if (prev != null) {
                prev.next = curr.next;
            } else {
                // If prev is null, it means the first node is being deleted
                head = curr.next;
            }
        } else {
            System.out.println("Value not found");
        }
    }

    public ListNode deleteDuplicateUnsorted(ListNode head)
    {
        if(head == null) return null;
        ListNode prev = null;
        ListNode curr = head;

        ListNode temp = new ListNode(0);

        Map<Integer , Boolean> visited = new HashMap<>();

        while(curr != null)
        {
            if (visited.containsKey(curr.data))
            {
                deleteUsingValue(curr.data);
                prev.next =curr.next;
            }
            else {
                visited.put(curr.data, true);
                insertAtEnd(curr.data);
            }

            prev = curr;
            curr =curr.next;
        }
        return head.next;
    }

}
