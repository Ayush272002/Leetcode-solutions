#include <bits/stdc++.h>
using namespace std;

class MyStack
{
private:
    queue<int> q1;
    queue<int> q2;
    int topVal;

public:
    MyStack()
    {
    }

    void push(int x)
    {
        q1.push(x);
        topVal = x;
    }

    int pop()
    {
        while (q1.size() != 1)
        {
            int x = q1.front();
            topVal = x;
            q1.pop();
            q2.push(x);
        }

        int val = q1.front();
        q1.pop();
        while (!q2.empty())
        {
            int x = q2.front();
            q2.pop();
            q1.push(x);
        }

        return val;
    }

    int top()
    {
        return topVal;
    }

    bool empty()
    {
        return q1.empty();
    }
};

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack* obj = new MyStack();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->top();
 * bool param_4 = obj->empty();
 */