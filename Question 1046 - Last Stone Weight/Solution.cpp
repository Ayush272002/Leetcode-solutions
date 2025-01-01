#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int lastStoneWeight(vector<int> &stones)
    {
        priority_queue<int> pq;

        for (int &n : stones)
            pq.push(n);

        while (!pq.empty())
        {
            int first = pq.top();
            pq.pop();

            if (pq.empty())
                return first;

            int second = pq.top();
            pq.pop();

            pq.push(abs(first - second));
        }

        return 0;
    }
};