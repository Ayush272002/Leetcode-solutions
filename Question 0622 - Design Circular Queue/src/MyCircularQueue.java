class MyCircularQueue {
    private final int[] arr;
    private int front;
    private int rear;
    private final int size;

    public MyCircularQueue(int k) {
        this.size = k;
        arr = new int[size];
        front = rear = -1;
    }

    public boolean enQueue(int value) {
        if(isFull()) return false;

        else if(front == -1)
            front = rear = 0;
        else if(rear == size-1 && front !=0)
            rear = 0;
        else
            rear++;

        arr[rear] = value;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()) return false;

        arr[front] = -1;
        if(front == rear)
            front = rear = -1;
        else if(front == size -1)
            front = 0;
        else
            front++;

        return true;

    }

    public int Front() {
        if(isEmpty()) return -1;
        else
            return arr[front];
    }

    public int Rear() {
        if(isEmpty()) return -1;
        else
            return arr[rear];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (front == 0 && rear == size - 1) || ((rear + 1) % size == front);
    }

}
