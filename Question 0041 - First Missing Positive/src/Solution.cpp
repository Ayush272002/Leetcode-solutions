#include<bits/stdc++.h>
using namespace std;

class Solution 
{
public:
    int firstMissingPositive(vector<int>& nums) 
    {
        int ans = 1;
        
        int i = 0, n = nums.size();
        while(i < n)
        {
            if(nums[i] > 0 && nums[i] < n && nums[i] != nums[nums[i] -1]) swap(nums[i], nums[nums[i] -1]);
            else i++;
        }

        for(int i = 0; i < nums.size(); i++)
        {
            if(ans == nums[i]) ans++;
        }

        return ans;
    }
};