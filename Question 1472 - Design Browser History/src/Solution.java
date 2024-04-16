class BrowserHistory
{
    private class Node
    {
        String data;
        Node next, prev;

        public Node(String data) {
            this.data = data;
        }
    }

    int size, curr;
    Node browser;

    public BrowserHistory(String homepage)
    {
        browser = new Node(homepage);
        size = 1;
        curr = 1;
    }

    public void visit(String url)
    {
        size = curr;

        int i = 1;
        Node temp = browser;
        while(i < curr)
        {
            temp = temp.next;
            i++;
        }

        Node visiteNode = new Node(url);
        temp.next = visiteNode;
        visiteNode.prev = temp;
        curr++;
        size++;
    }

    public String back(int steps)
    {
        int st = Math.max(curr - steps, 1);

        Node temp = browser;
        int i = 1;
        while(i != curr)
        {
            temp = temp.next;
            i++;
        }

        while(curr != st)
        {
            curr--;
            temp = temp.prev;
        }

        return temp.data;

    }

    public String forward(int steps)
    {
        int val = Math.min(curr + steps, size);

        Node temp = browser;
        int i = 1;
        while (i != val && temp != null)
        {
            temp = temp.next;
            i++;
        }

        if (temp != null)
        {
            curr = i;
            return temp.data;
        }
        else return null;

    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */