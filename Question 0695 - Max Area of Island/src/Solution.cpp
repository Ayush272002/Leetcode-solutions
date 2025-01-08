#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    int dfs(vector<vector<int>> &grid, vector<vector<int>> &dir, int r, int c)
    {
        if (r < 0 || r >= grid.size() || c < 0 || c >= grid[0].size() || grid[r][c] == 0)
            return 0;

        int ans = 1;
        grid[r][c] = 0;
        for (auto &d : dir)
        {
            int x = r + d[0];
            int y = c + d[1];

            ans += dfs(grid, dir, x, y);
        }

        return ans;
    }

public:
    int maxAreaOfIsland(vector<vector<int>> &grid)
    {
        int n = grid.size(), m = grid[0].size();

        int ans = INT_MIN;
        vector<vector<int>> dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (grid[i][j] == 1)
                    ans = max(ans, dfs(grid, dir, i, j));
            }
        }

        return ans == INT_MIN ? 0 : ans;
    }
};