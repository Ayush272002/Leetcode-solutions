#include<bits/stdc++.h>
using namespace std;

void solve(vector<int>& nums, vector<int>& curr, vector<vector<int>>& ans, vector<int>& visited)
{
    if(curr.size() == nums.size())
    {
        if(find(ans.begin(), ans.end(), curr) == ans.end()) ans.push_back(curr);
        return;
    }

    for(int i = 0; i < nums.size(); i++)
    {
        if(visited[i]) continue;

        visited[i] = 1;
        curr.push_back(nums[i]);
        solve(nums, curr, ans, visited);
        curr.pop_back();
        visited[i] = 0;
    }
}

class Solution 
{
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) 
    {
        vector<int> curr;
        vector<vector<int>> ans;
        vector<int> visited(nums.size(), 0);
        solve(nums, curr, ans, visited);
        return ans;
    }
};