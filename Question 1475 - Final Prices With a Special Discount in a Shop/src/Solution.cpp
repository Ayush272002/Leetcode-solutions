#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    vector<int> finalPrices(vector<int> &prices)
    {
        vector<int> ans;
        stack<int> st;

        for (int i = prices.size() - 1; i >= 0; i--)
        {
            while (!st.empty() && st.top() > prices[i])
                st.pop();

            int disc = st.empty() ? 0 : st.top();

            ans[i] = prices[i] - disc;

            st.push(prices[i]);
        }

        return ans;
    }
};