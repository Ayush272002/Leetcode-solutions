#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
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

    int largestRectangleArea(vector<int> &heights, int n)
    {
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

public:
    int maximalRectangle(vector<vector<char>> &matrix)
    {
        vector<vector<int>> M(matrix.size(), vector<int>(matrix[0].size()));
        int n = matrix.size();
        int m = matrix[0].size();
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (matrix[i][j] == '1')
                    M[i][j] = 1;
                else
                    M[i][j] = 0;
            }
        }

        // step 1: ans for 1st row
        int area = largestRectangleArea(M[0], m);
        for (int i = 1; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                // row update
                if (M[i][j] != 0)
                    M[i][j] = M[i][j] + M[i - 1][j];
                else
                    M[i][j] = 0;
            }

            //entire row is updated now
            area = max(area, largestRectangleArea(M[i], m));
        }

        return area;
    }
};