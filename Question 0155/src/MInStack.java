class MinStack {
    private Node head;

    public MinStack() {

    }

    public void push(int val) {
        Node temp = new Node(val);
        temp.next = head;
        head = temp;
    }

    public void pop() {
        if(head == null) return;

        head = head.next;
    }

    public int top() {
        if(head == null) return -1;

        return head.data;
    }

    public int getMin() {
        if(head == null)
        {
            System.out.println("Stack is empty");
            return -1;
        }
        Node temp = head;
        int min = temp.data;

        while(temp != null)
        {
            min = Math.min(min, temp.data);
            temp = temp.next;
        }
        return min;
    }
}
