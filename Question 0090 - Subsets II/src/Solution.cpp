#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    void solve(vector<int> &nums, vector<vector<int>> &ans, vector<int> &curr, int idx)
    {
        ans.push_back(curr);

        for (int i = idx; i < nums.size(); i++)
        {
            if(i > idx && nums[i] == nums[i-1]) continue;
            curr.push_back(nums[i]);
            solve(nums, ans, curr, i+1);
            curr.pop_back();
        }
    }

public:
    vector<vector<int>> subsetsWithDup(vector<int> &nums)
    {
        vector<vector<int>> ans;
        vector<int> curr;
        sort(nums.begin(), nums.end());
        solve(nums, ans, curr, 0);
        return ans;
    }
};