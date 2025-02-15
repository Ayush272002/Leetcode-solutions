#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    int dfs(vector<vector<int>> &grid, vector<vector<int>> &dir, int r, int c, vector<vector<bool>> &vis)
    {
        if (r < 0 || r >= grid.size() || c < 0 || c >= grid[0].size() || vis[r][c] || grid[r][c] == 0)
            return 0;

        vis[r][c] = true;
        int ans = grid[r][c];
        for (auto &d : dir)
        {
            int x = r + d[0];
            int y = c + d[1];

            ans += dfs(grid, dir, x, y, vis);
        }

        return ans;
    }

public:
    int findMaxFish(vector<vector<int>> &grid)
    {
        int m = grid.size(), n = grid[0].size();

        vector<vector<int>> dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        vector<vector<bool>> vis(m, vector<bool>(n, false));

        int ans = 0;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] > 0 && !vis[i][j])
                {
                    ans = max(ans, dfs(grid, dir, i, j, vis));
                }
            }
        }

        return ans;
    }
};