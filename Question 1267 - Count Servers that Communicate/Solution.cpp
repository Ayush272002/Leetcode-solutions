#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int countServers(vector<vector<int>> &grid)
    {
        int m = grid.size(), n = grid[0].size();

        vector<int> rowCount(m, 0), colCount(n, 0);
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j])
                {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] && (rowCount[i] > 1 || colCount[j] > 1))
                    ans++;
            }
        }

        return ans;
    }
};