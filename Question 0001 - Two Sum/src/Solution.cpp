#include<bits/stdc++.h>
using namespace std;

typedef unordered_map<int, int> umii;

#define pb push_back

class Solution 
{
public:
    vector<int> twoSum(vector<int>& nums, int target) 
    {
        vector<int> ans;
        umii map;
        int n = nums.size();

        for(int i = 0; i < n; ++i) map[nums[i]] = i;

        for(int i = 0; i < n; i++)
        {
            int comp = target - nums[i];
            if(map.find(comp) != map.end() && map[comp] != i)
            {
                ans.pb(i);
                ans.pb(map[comp]);
                break;
            }

        }

        return ans;
    }
};