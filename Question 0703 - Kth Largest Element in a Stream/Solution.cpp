#include <bits/stdc++.h>
using namespace std;

class KthLargest
{
private:
private:
    priority_queue<int, vector<int>, greater<int>> q;
    int k;

public:
    KthLargest(int k, vector<int> &nums)
    {
        this->k = k;

        for (int n : nums)
            q.push(n);
    }

    int add(int val)
    {
        q.push(val);

        while (q.size() > k)
        {
            q.pop();
        }

        return q.top();
    }
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 */