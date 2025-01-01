#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    int solve(vector<int> &arr, int k, int idx, vector<int> &dp)
    {
        if (idx >= arr.size())
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        int maxInPartition = INT_MIN;
        int maxSum = 0;

        for (int i = 1; i <= k && idx + i - 1 < arr.size(); i++)
        {
            maxInPartition = max(maxInPartition, arr[idx + i - 1]);
            int currSum = maxInPartition * i + solve(arr, k, idx + i, dp);
            maxSum = max(maxSum, currSum);
        }

        return dp[idx] = maxSum;
    }

public:
    int maxSumAfterPartitioning(vector<int> &arr, int k)
    {
        vector<int> dp(arr.size(), -1);
        return solve(arr, k, 0, dp);
    }
};