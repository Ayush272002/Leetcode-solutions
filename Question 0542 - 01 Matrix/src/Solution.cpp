#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    vector<vector<int>> updateMatrix(vector<vector<int>> &mat)
    {
        int m = mat.size(), n = mat[0].size();

        vector<vector<int>> dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        queue<pair<int, int>> q;
        vector<vector<int>> ans(m, vector<int>(n, INT_MAX));

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (mat[i][j] == 0)
                {
                    q.push({i, j});
                    ans[i][j] = 0;
                }
            }
        }

        while (!q.empty())
        {
            pair<int, int> tmp = q.front();
            q.pop();

            for (auto &d : dir)
            {
                int x = tmp.first + d[0];
                int y = tmp.second + d[1];

                if (x >= 0 && x < m && y >= 0 && y < n && ans[x][y] > ans[tmp.first][tmp.second] + 1)
                {
                    ans[x][y] = ans[tmp.first][tmp.second] + 1;
                    q.push({x, y});
                }
            }
        }

        return ans;
    }
};