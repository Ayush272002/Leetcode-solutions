#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    vector<int> minOperations(string boxes)
    {
        int n = boxes.size(), ops = 0, cnt = 0;
        vector<int> ans(n, 0);

        for (int i = 0; i < n; i++)
        {
            ans[i] += ops;
            cnt += (boxes[i] == '1') ? 1 : 0;
            ops += cnt;
        }

        ops = 0, cnt = 0;
        for (int i = n - 1; i >= 0; i--)
        {
            ans[i] += ops;
            cnt += (boxes[i] == '1') ? 1 : 0;
            ops += cnt;
        }

        return ans;
    }
};