#include<bits/stdc++.h>
using namespace std;

int solve(vector<int>& nums, int idx, int val, vector<int>& dp)
{
    if(idx >= nums.size()-1) return 0;
    if(dp[idx] != -1) return dp[idx];

    int ans = INT_MAX;
    for(int i = 1; i <= val && i + idx < nums.size(); i++)
    {
        int jmp =  solve(nums, idx+i, nums[idx+i], dp);
        if(jmp != INT_MAX) ans = min(ans, 1 + jmp);
    }

    return dp[idx] = ans;
}

class Solution 
{
public:
    int jump(vector<int>& nums) 
    {
        vector<int> dp(nums.size(), -1);
        return solve(nums, 0, nums[0], dp);
    }
};