#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    pair<int, int> solve(vector<int> &nums, int idx, int prev, vector<vector<pair<int, int>>> &dp)
    {
        if (idx == nums.size())
            return make_pair(0, 1);

        if (dp[idx][prev + 1].first != -1)
            return dp[idx][prev + 1];

        int length = 0, count = 0;

        if (prev == -1 || nums[prev] < nums[idx])
        {
            pair<int, int> include = solve(nums, idx + 1, idx, dp);
            int includeLength = 1 + include.first;

            if (includeLength > length)
            {
                length = includeLength;
                count = include.second;
            }
            else if (includeLength == length)
                count += include.second;
        }

        pair<int, int> exclude = solve(nums, idx + 1, prev, dp);
        if (exclude.first > length)
        {
            length = exclude.first;
            count = exclude.second;
        }
        else if (exclude.first == length)
            count += exclude.second;

        dp[idx][prev + 1] = make_pair(length, count);
        return dp[idx][prev + 1];
    }

public:
    int findNumberOfLIS(vector<int> &nums)
    {
        vector<vector<pair<int, int>>> dp(nums.size(), vector<pair<int, int>>(nums.size() + 1, make_pair(-1, -1)));
        return solve(nums, 0, -1, dp).second;
    }
};