#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    int solve(int idx, int buy, vector<int> &prices, vector<vector<int>> &dp)
    {
        // base case
        if (idx >= prices.size())
            return 0;

        if (dp[idx][buy] != -1)
            return dp[idx][buy];

        int profit = 0;
        if (buy == 1)
        {
            int buyNow = -prices[idx] + solve(idx + 1, 0, prices, dp);
            int buyLater = solve(idx + 1, 1, prices, dp);
            profit = max(buyNow, buyLater);
        }
        else
        {
            int sellNow = prices[idx] + solve(idx + 1, 1, prices, dp);
            int sellLater = solve(idx + 1, 0, prices, dp);
            profit = max(sellNow, sellLater);
        }

        return dp[idx][buy] = profit;
    }

public:
    int maxProfit(vector<int> &prices)
    {
        vector<vector<int>> dp(prices.size(), vector<int>(2, -1));
        return solve(0, 1, prices, dp);
    }
};