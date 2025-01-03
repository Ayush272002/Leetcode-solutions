#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    int solve(vector<int> &coins, int target, int idx, vector<vector<int>> &dp)
    {
        if (target == 0)
            return 1;

        if (target < 0 || idx >= coins.size())
            return 0;

        if (dp[target][idx] != -1)
            return dp[target][idx];

        int include = solve(coins, target - coins[idx], idx, dp);

        int exclude = solve(coins, target, idx + 1, dp);

        return dp[target][idx] = include + exclude;
    }

public:
    int change(int amount, vector<int> &coins)
    {
        vector<vector<int>> dp(amount + 1, vector<int>(coins.size() + 1, -1));
        return solve(coins, amount, 0, dp);
    }
};