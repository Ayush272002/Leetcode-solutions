#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    int solve(vector<int> &nums, int target, int curr, int idx, unordered_map<string, int> &dp)
    {
        if (idx == nums.size())
        {
            return curr == target ? 1 : 0;
        }

        string key = to_string(idx) + "," + to_string(curr);

        if (dp.find(key) != dp.end())
            return dp[key];

        string str1 = "-", str2 = "+";
        str1 += nums[idx];
        str2 += nums[idx];

        int add = solve(nums, target, curr + nums[idx], idx + 1, dp);
        int subtract = solve(nums, target, curr - nums[idx], idx + 1, dp);

        return dp[key] = add + subtract;
    }

public:
    int findTargetSumWays(vector<int> &nums, int target)
    {
        unordered_map<string, int> dp;
        return solve(nums, target, 0, 0, dp);
    }
};