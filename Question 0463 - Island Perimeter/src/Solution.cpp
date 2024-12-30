#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int islandPerimeter(vector<vector<int>> &grid)
    {
        int n = grid.size(), m = grid[0].size();
        vector<vector<int>> dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        int count = 0;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (grid[i][j])
                {
                    for (auto &d : dir)
                    {
                        int x = i + d[0];
                        int y = j + d[1];

                        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0)
                            count++;
                    }
                }
            }
        }

        return count;
    }
};