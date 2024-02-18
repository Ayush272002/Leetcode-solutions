public class Solution {
    Node insertAtEnd(Node head, int data)
    {
        Node temp = new Node();
        temp.val = data;
        temp.child = null;

        if(head == null)
        {
            head = temp;
            return head;
        }

        Node node = head;

        while (node.next != null) node = node.next;

        temp.prev = node;
        node.next = temp;

        return head;
    }

    Node flattenChild(Node head, Node child)
    {
        while(child != null) {
            head = insertAtEnd(head, child.val);

            if (child.child != null)
                head = flattenChild(head, child.child);

            child = child.next;
        }

        return head;
    }

    public Node flatten(Node head) {
        if(head == null) return null;
        Node sol = null;

        Node temp = head;

        while(temp != null)
        {
            sol = insertAtEnd(sol , temp.val);
            if(temp.child != null)
            {
                sol = flattenChild(sol,temp.child);
            }
            temp = temp.next;
        }
        return sol;
    }
}