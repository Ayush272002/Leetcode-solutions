class MyCircularDeque {
    int[] arr;
    int front;
    int rear;
    int size;

    public MyCircularDeque(int k) {
        this.size = k;
        arr = new int[size];
        front = rear = -1;
    }

    public boolean insertFront(int value) {
        if(isFull()) return false;

        else if(front == -1) front=rear=0;
        else if(front == 0 && rear != size-1) front = size-1;
        else front--;
        arr[front] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull()) return false;

        else if(front == -1) front = rear = 0;
        else if(rear == size -1 && front != 0) rear =0;
        else rear++;

        arr[rear] = value;
        return true;
    }

    public boolean deleteFront() {
        if(isEmpty()) return false;

        arr[front] = -1;    //storing a negative value which represents null

        if(front == rear) front = rear = -1;
        else if(front == size - 1)  front =0;
        else front++;

        return true;
    }

    public boolean deleteLast() {
        if(isEmpty()) return false;

        arr[rear] = -1;

        if(front == rear) front = rear = -1;
        else if(rear == 0) rear = size -1;
        else rear--;
        return true;
    }

    public int getFront() {
        if(isEmpty()) return -1;
        else return arr[front];
    }

    public int getRear() {
        if(isEmpty()) return -1;
        else return arr[rear];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (front == 0 && rear == size - 1) || ((rear + 1) % size == front);
    }
}