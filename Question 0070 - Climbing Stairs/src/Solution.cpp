#include<bits/stdc++.h>
using namespace std;

int solve(int n, vector<int>& dp)
{
    //base case
    if(n < 0) return 0;
    if(n == 0 || n == 1) return 1;
    if(dp[n] != -1) return dp[n];

    return dp[n] = solve(n-1, dp) + solve(n-2, dp);
}

class Solution 
{
public:
    int climbStairs(int n) 
    {
        vector<int> dp(n+1, -1);
        return solve(n, dp);
    }
};