#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    bool solve(vector<int> &nums, int target, int idx, vector<vector<int>> &dp)
    {
        if (idx >= nums.size())
            return false;

        if (target < 0)
            return false;

        if (target == 0)
            return true;

        if (dp[idx][target] != -1)
            return dp[idx][target];

        // take
        bool take = solve(nums, target - nums[idx], idx + 1, dp);

        // skip
        bool skip = solve(nums, target, idx + 1, dp);

        return dp[idx][target] = take || skip;
    }

public:
    bool canPartition(vector<int> &nums)
    {
        int sum = 0;
        for (int n : nums)
            sum += n;

        if (sum % 2 != 0)
            return false;

        vector<vector<int>> dp(nums.size(), vector<int>(sum / 2 + 1, -1));

        return solve(nums, sum / 2, 0, dp);
    }
};