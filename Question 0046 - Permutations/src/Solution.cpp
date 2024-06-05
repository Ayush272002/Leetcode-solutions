#include<bits/stdc++.h>
using namespace std;

void solve(vector<int>& nums, vector<int>& curr, vector<vector<int>>& ans)
{
    if(curr.size() == nums.size())
    {
        ans.push_back(curr);
        return;
    }

    for(int i = 0; i < nums.size(); i++)
    {
        if(find(curr.begin(), curr.end(), nums[i]) != curr.end()) continue;

        curr.push_back(nums[i]);
        solve(nums, curr, ans);
        curr.pop_back();
    }
}

class Solution 
{
public:
    vector<vector<int>> permute(vector<int>& nums) 
    {
        vector<int> curr;
        vector<vector<int>> ans;
        solve(nums, curr, ans);
        return ans;
    }
};