class MyLinkedList {
    Node head;

    public MyLinkedList() {

    }

    private int getSize()
    {
        if(head == null) return 0;

        Node temp = head;
        int sz =0 ;
        while(temp != null) {
            temp = temp.next;
            sz++;
        }
        return sz;
    }

    public int get(int index) {
        if(head == null || index < 0) return -1;
        int sz = getSize();
        if(index > sz ) return -1;

        Node curr = head;
        int i=0;
        while(curr !=null && i!=index)
        {
            curr = curr.next;
            i++;
        }

        if(curr != null) return curr.data;
        else return -1;
    }

    public void addAtHead(int val) {

        Node temp = new Node(val);
        temp.next = head;
        head = temp;

    }

    public void addAtTail(int val) {
        Node node = new Node(val);

        if(head == null) head = node;

        else
        {
            Node temp = head;
            while(temp.next != null) temp = temp.next;
            temp.next = node;
        }

    }

    public void addAtIndex(int index, int val) {
        if(index == 0) {
            addAtHead(val);
            return;
        }
        if(index == getSize())
        {
            addAtTail(val);
            return;
        }
        if(index > getSize()) return;

        Node temp = head;

        for (int i = 0; i < index-1; i++) {
            temp = temp.next;
        }

        if(temp.next == null)
        {
            addAtTail(val);
            return;
        }

        Node node = new Node(val);
        node.next = temp.next;
        temp.next = node;
    }


    public void deleteAtIndex(int index) {
        if(index == 0)
        {
            Node temp = head;
            head = head.next;
            temp.next = null;
        }
        else
        {
            Node curr = head;
            Node prev = null;

            for (int i = 0; i < index && curr != null; i++) {
                prev = curr;
                curr =curr.next;
            }
            if(curr != null)
            {
                if(prev !=null) prev.next =curr.next;
                else head=curr.next;
            }
        }
    }
}