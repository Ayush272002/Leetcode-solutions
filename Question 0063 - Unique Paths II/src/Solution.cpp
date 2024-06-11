#include<bits/stdc++.h>
using namespace std;

int solve(vector<vector<int>>& obstacleGrid, int r, int c, vector<vector<long long>>& dp)
{
    if(r == obstacleGrid.size()-1 && c == obstacleGrid[0].size()-1 && obstacleGrid[r][c] == 0) return 1;
    if(r < 0 || r >= obstacleGrid.size() || c < 0 || c >= obstacleGrid[0].size() || obstacleGrid[r][c] == 1) return 0;
    if(dp[r][c] != -1) return dp[r][c];

    int ans = 0;

    //down
    ans += solve(obstacleGrid, r+1, c, dp);

    //right
    ans += solve(obstacleGrid, r, c+1, dp);

    return dp[r][c] = ans;
}

class Solution 
{
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) 
    {
        if(obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.size()-1][obstacleGrid[0].size()-1] == 1) return 0;
        vector<vector<long long>> dp(obstacleGrid.size(), vector<long long>(obstacleGrid[0].size(), -1));
        return solve(obstacleGrid, 0, 0, dp);
    }
};