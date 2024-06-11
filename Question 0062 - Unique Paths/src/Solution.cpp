#include<bits/stdc++.h>
using namespace std;

int solve(int r, int c, int m, int n, vector<vector<int>>& dp)
{
    if(r == m-1 && c == n-1) return 1;
    if(r < 0 || r >= m || c < 0 || c >= n) return 0;
    if(dp[r][c] != -1) return dp[r][c];

    int ans = 0;
    //down
    ans = ans + solve(r+1, c, m, n, dp);

    //right
    ans = ans + solve(r, c+1, m, n, dp);

    return dp[r][c] = ans;
}

class Solution 
{
public:
    int uniquePaths(int m, int n) 
    {
        vector<vector<int>> dp(m, vector<int>(n, -1));
        return solve(0, 0, m, n, dp);
    }
};