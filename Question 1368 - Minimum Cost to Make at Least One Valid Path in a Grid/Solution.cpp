#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int minCost(vector<vector<int>> &grid)
    {
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        vector<vector<int>> cost(m, vector<int>(n, INT_MAX));
        priority_queue<tuple<int, int, int>, vector<tuple<int, int, int>>, greater<>> pq;

        pq.emplace(0, 0, 0);
        cost[0][0] = 0;

        while (!pq.empty())
        {
            auto [currCost, x, y] = pq.top();
            pq.pop();

            for (int d = 0; d < 4; d++)
            {
                int nx = x + dir[d][0];
                int ny = y + dir[d][1];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                    continue;

                int nextCost = currCost + (d != grid[x][y] - 1);

                if (nextCost < cost[nx][ny])
                {
                    cost[nx][ny] = nextCost;
                    pq.emplace(nextCost, nx, ny);
                }
            }
        }

        return cost[m - 1][n - 1];
    }
};