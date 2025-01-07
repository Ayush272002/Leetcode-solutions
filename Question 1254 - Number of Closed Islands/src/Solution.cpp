#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    bool dfs(vector<vector<int>> &grid, int r, int c)
    {
        if (r < 0 || r >= grid.size() || c < 0 || c >= grid[0].size())
            return false;

        if (grid[r][c] == 1)
            return true;

        grid[r][c] = 1;

        bool up = dfs(grid, r - 1, c);
        bool down = dfs(grid, r + 1, c);
        bool left = dfs(grid, r, c - 1);
        bool right = dfs(grid, r, c + 1);

        return up && down && left && right;
    }

public:
    int closedIsland(vector<vector<int>> &grid)
    {
        int n = grid.size(), m = grid[0].size();

        int ans = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (grid[i][j] == 0 && dfs(grid, i, j))
                    ans++;
            }
        }

        return ans;
    }
};