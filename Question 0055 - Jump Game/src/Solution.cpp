#include<bits/stdc++.h>
using namespace std;

bool solve(vector<int>& nums, int idx, int curr, vector<int>& dp)
{
    if(idx == nums.size()-1) return true;
    if(idx >= nums.size()) return false;
    if(dp[idx] != -1) return dp[idx];

    bool ans = false;
    for(int i = 1; i <= curr && idx+i < nums.size(); i++)
    {
        ans = ans || solve(nums, idx+i, nums[idx+i], dp);
    }

    return dp[idx] = ans;
}

class Solution 
{
public:
    bool canJump(vector<int>& nums) 
    {
        vector<int> dp(nums.size(), -1);
        return solve(nums, 0, nums[0], dp);
    }
};