#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    int solve(vector<vector<int>> &triangle, int r, int idx, vector<vector<int>> &dp)
    {
        if (r >= triangle.size())
            return 0;

        if (dp[r][idx] != -1)
            return dp[r][idx];

        int prev = triangle[r][idx] + solve(triangle, r + 1, idx, dp);

        int next = INT_MAX;
        if (triangle[r].size() > idx + 1)
            next = triangle[r][idx + 1] + solve(triangle, r + 1, idx + 1, dp);

        return dp[r][idx] = min(prev, next);
    }

public:
    int minimumTotal(vector<vector<int>> &triangle)
    {
        vector<vector<int>> dp(triangle.size(), vector<int>(triangle.size(), -1));
        return solve(triangle, 0, 0, dp);
    }
};