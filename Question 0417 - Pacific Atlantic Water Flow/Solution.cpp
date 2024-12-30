#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    void dfs(vector<vector<int>> &matrix, int r, int c, int prev, vector<vector<bool>> &ocean, vector<vector<int>> &dir)
    {
        if (r < 0 || r >= matrix.size() || c < 0 || c >= matrix[0].size())
            return;

        if (ocean[r][c] || matrix[r][c] < prev)
            return;

        ocean[r][c] = true;
        for (auto &d : dir)
        {
            int x = r + d[0];
            int y = c + d[1];

            dfs(matrix, x, y, matrix[r][c], ocean, dir);
        }
    }

public:
    vector<vector<int>> pacificAtlantic(vector<vector<int>> &heights)
    {
        vector<vector<int>> ans;

        int n = heights.size(), m = heights[0].size();
        vector<vector<bool>> pac(n, vector<bool>(m, false));
        vector<vector<bool>> atlantic(n, vector<bool>(m, false));

        vector<vector<int>> dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < n; i++)
        {
            dfs(heights, i, 0, heights[i][0], pac, dir);
            dfs(heights, i, m - 1, heights[i][m - 1], atlantic, dir);
        }

        for (int i = 0; i < m; i++)
        {
            dfs(heights, 0, i, heights[0][i], pac, dir);
            dfs(heights, n - 1, i, heights[n - 1][i], atlantic, dir);
        }

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (pac[i][j] && atlantic[i][j])
                    ans.push_back({i, j});
            }
        }

        return ans;
    }
};