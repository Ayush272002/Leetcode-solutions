#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    int solve(vector<int> &nums, int idx, int prev)
    {
        if (idx == nums.size())
            return 0;

        int include = 0;
        if (prev == -1 || nums[idx] > nums[prev])
        {
            include = 1 + solve(nums, idx + 1, idx);
        }

        int exclude = solve(nums, idx + 1, prev);

        return max(include, exclude);
    }

    int solve2(vector<int> &nums)
    {
        int n = nums.size();
        vector<vector<int>> dp(n + 1, vector<int>(n + 1, 0));

        for (int curr = n - 1; curr >= 0; curr--)
        {
            for (int prev = curr - 1; prev >= -1; prev--)
            {
                int include = 0;
                if (prev == -1 || nums[curr] > nums[prev])
                {
                    include = 1 + dp[curr + 1][curr + 1];
                }

                int exclude = dp[curr + 1][prev + 1];

                dp[curr][prev + 1] = max(include, exclude);
            }
        }

        return dp[0][0];
    }

public:
    int lengthOfLIS(vector<int> &nums)
    {
        // return solve(nums, 0, -1);
        return solve2(nums);
    }
};