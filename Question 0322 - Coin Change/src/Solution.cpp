#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    int solve(vector<int> &coins, int amount, vector<int> &dp)
    {
        if (amount == 0)
            return 0;

        if (amount < 0)
            return INT_MAX;

        if (dp[amount] != -1)
            return dp[amount];

        int ans = INT_MAX;
        for (int i = 0; i < coins.size(); i++)
        {
            int curr = 0;
            curr += solve(coins, amount - coins[i], dp);
            if (curr != INT_MAX)
                ans = min(ans, 1 + curr);
        }

        return dp[amount] = ans;
    }

public:
    int coinChange(vector<int> &coins, int amount)
    {
        vector<int> dp(amount + 1, -1);
        int ans = solve(coins, amount, dp);
        return ans == INT_MAX ? -1 : ans;
    }
};