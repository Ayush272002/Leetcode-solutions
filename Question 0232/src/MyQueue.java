import java.util.Stack;

class MyQueue {
    Stack<Integer> s1;
    private int peek;

    public MyQueue() {
        s1 = new Stack<>();
    }
    Stack<Integer> solve(Stack<Integer> myStack, int x)
    {
        if(myStack.isEmpty())
        {
            myStack.push(x);
            return myStack;
        }

        int num = myStack.pop();

        //recursive call
        solve(myStack , x);

        myStack.push(num);
        return myStack;
    }

    public void push(int x) {
        s1 = solve(s1,x);
    }

    public int pop() {
        return s1.pop();
    }

    public int peek() {
       return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}
