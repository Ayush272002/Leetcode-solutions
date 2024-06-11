#include<bits/stdc++.h>
using namespace std;

void solve(vector<int>& nums, vector<vector<int>>& ans, vector<int>& curr, int idx)
{
    if(idx >= nums.size())
    {
        ans.push_back(curr);
        return;
    }

    //take
    curr.push_back(nums[idx]);
    solve(nums, ans, curr, idx+1);
    curr.pop_back();

    //skip
    solve(nums, ans, curr, idx+1);
}

class Solution 
{
public:
    vector<vector<int>> subsets(vector<int>& nums) 
    {
        vector<vector<int>> ans;
        vector<int> curr;
        solve(nums, ans, curr, 0);
        return ans;
    }
};