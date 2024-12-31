#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    int solve(vector<vector<int>> &grid, vector<vector<bool>> &visited, int i, int j, int gold, vector<vector<int>> &dir)
    {
        visited[i][j] = true;
        int maxGold = gold;

        for (auto &d : dir)
        {
            int x = i + d[0];
            int y = j + d[1];

            if (x >= 0 && x < grid.size() && y >= 0 && y < grid[0].size() && !visited[x][y] && grid[x][y] != 0)
            {
                maxGold = max(maxGold, grid[x][y] + solve(grid, visited, x, y, gold, dir));
            }
        }

        visited[i][j] = false;
        return maxGold;
    }

public:
    int getMaximumGold(vector<vector<int>> &grid)
    {
        int r = grid.size(), c = grid[0].size();

        int currGold = 0, maxGold = INT_MIN;
        vector<vector<bool>> visited(r, vector<bool>(c, false));
        vector<vector<int>> dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                if (!visited[i][j])
                {
                    currGold = solve(grid, visited, i, j, grid[i][j], dir);
                }

                maxGold = max(maxGold, currGold);
            }
        }

        return maxGold;
    }
};