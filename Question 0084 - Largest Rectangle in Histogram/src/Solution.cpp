#include <bits/stdc++.h>
using namespace std;

vector<int> nextSmallerElement(vector<int> &heights, int n)
{
    stack<int> st;
    st.push(-1);
    vector<int> ans(n);

    for (int i = n - 1; i >= 0; i--)
    {
        int curr = heights[i];
        while (st.top() != -1 && heights[st.top()] >= curr)
            st.pop();

        ans[i] = st.top();
        st.push(i);
    }

    return ans;
}

vector<int> prevSmallerElement(vector<int> &heights, int n)
{
    stack<int> st;
    st.push(-1);
    vector<int> ans(n);

    for (int i = 0; i < n; i++)
    {
        int curr = heights[i];
        while (st.top() != -1 && heights[st.top()] >= curr)
            st.pop();

        ans[i] = st.top();
        st.push(i);
    }

    return ans;
}

class Solution
{
public:
    int largestRectangleArea(vector<int> &heights)
    {
        int n = heights.size();

        vector<int> next = nextSmallerElement(heights, n);
        vector<int> prev = prevSmallerElement(heights, n);

        int area = INT_MIN;
        for (int i = 0; i < n; i++)
        {
            int l = heights[i];
            if (next[i] == -1)
                next[i] = n;
            int b = next[i] - prev[i] - 1;
            int newArea = l * b;
            area = max(area, newArea);
        }

        return area;
    }
};