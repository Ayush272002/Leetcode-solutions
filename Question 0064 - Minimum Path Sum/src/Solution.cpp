#include<bits/stdc++.h>
using namespace std;

int solve(vector<vector<int>>& grid, int r, int c, vector<vector<int>>& dir, vector<vector<int>>& dp)
{
    if(r == grid.size() -1 && c == grid[0].size()-1) return grid[r][c];
    if(r < 0 || r >= grid.size() || c < 0 || c >= grid[0].size()) return 0;
    if(dp[r][c] != -1)  return dp[r][c];

    int mini = INT_MAX;
    for(auto& d : dir)
    {
        int x = r + d[0];
        int y = c + d[1];
        if(x >= 0 && y >= 0 && x < grid.size() && y < grid[0].size())
        {
            mini = min(mini, grid[r][c] + solve(grid, x, y, dir, dp));
        }
    }

    return dp[r][c] = mini;
}

class Solution 
{
public:
    int minPathSum(vector<vector<int>>& grid) 
    {
        vector<vector<int>> dir = {{1,0}, {0, 1}};
        vector<vector<int>> dp (grid.size(), vector<int>(grid[0].size(), -1));
        return solve(grid, 0, 0, dir, dp);
    }
};