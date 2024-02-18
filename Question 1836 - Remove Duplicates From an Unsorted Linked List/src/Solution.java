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

    public ListNode deleteDuplicateUnsortedEasyMethod(ListNode head) {    //this is a better way of doing
        ListNode dummy = new ListNode(0, head);
        Map<Integer, Integer> count = new HashMap<>();

        for (ListNode curr = head; curr != null; curr = curr.next)
            count.merge(curr.data, 1, Integer::sum);

        ListNode curr = dummy;

        while (curr != null) {
            while (curr.next != null && count.containsKey(curr.next.data) && count.get(curr.next.data) > 1)
                curr.next = curr.next.next;
            curr = curr.next;
        }

        return dummy.next;
    }

    private ListNode deleteUsingValue(int data, ListNode head) {
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

        return head; // Return the modified head
    }


    public static int countOccurrences(ListNode head, int targetValue) {
        int count = 0;
        ListNode current = head;

        while (current != null) {
            if (current.data == targetValue) {
                count++;
            }
            current = current.next;
        }

        return count;
    }


    public ListNode deleteDuplicateUnsorted(ListNode head) {
        if (head == null)
            return null;

        ListNode temp = new ListNode(0); // Create a dummy node to simplify head update
        temp.next = head;

        Map<Integer, Boolean> visited = new HashMap<>();
        ListNode curr = head;

        while (curr != null) {
            if (visited.containsKey(curr.data)) {
                int count = countOccurrences(temp.next, curr.data);
                for (int i = 0; i < count; i++) {
                    temp.next = deleteUsingValue(curr.data, temp.next);
                }
            } else {
                visited.put(curr.data, true);
            }

            curr = curr.next;
        }
        return temp.next; // Return the modified head
    }


}
