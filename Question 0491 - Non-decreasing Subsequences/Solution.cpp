#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    void solve(vector<int> &nums, vector<vector<int>> &ans, vector<int> &curr, int idx)
    {
        if (curr.size() >= 2)
        {
            ans.push_back(curr);
        }

        set<int> used;

        for (int i = idx; i < nums.size(); i++)
        {
            if (!curr.empty() && nums[i] < curr.back())
                continue;

            if (used.find(nums[i]) != used.end())
                continue;

            used.insert(nums[i]);
            curr.push_back(nums[i]);
            solve(nums, ans, curr, i + 1);
            curr.pop_back();
        }
    }

public:
    vector<vector<int>> findSubsequences(vector<int> &nums)
    {
        vector<vector<int>> ans;
        vector<int> curr;

        solve(nums, ans, curr, 0);

        return ans;
    }
};