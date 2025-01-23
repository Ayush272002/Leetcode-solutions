#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    int solve(vector<vector<int>> &matrix, vector<vector<int>> &dir, int r, int c, vector<vector<int>> &dp)
    {
        if (dp[r][c] != -1)
            return dp[r][c];

        int max_path = 1;
        for (auto &d : dir)
        {
            int x = r + d[0];
            int y = c + d[1];

            if (x >= 0 && x < matrix.size() && y >= 0 && y < matrix[0].size() && matrix[r][c] < matrix[x][y])
            {
                max_path = max(max_path, 1 + solve(matrix, dir, x, y, dp));
            }
        }

        return dp[r][c] = max_path;
    }

public:
    int longestIncreasingPath(vector<vector<int>> &matrix)
    {
        int m = matrix.size(), n = matrix[0].size();

        int ans = INT_MIN;
        vector<vector<int>> dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        vector<vector<int>> dp(m, vector<int>(n, -1));

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                ans = max(ans, solve(matrix, dir, i, j, dp));
            }
        }

        return ans;
    }
};