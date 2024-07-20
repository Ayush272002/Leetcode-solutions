#include<bits/stdc++.h>
using namespace std;

class Solution 
{
public:
    int findDuplicate(vector<int>& nums) 
    {
        vector<bool> vis(nums.size(), 0);

        for(int &n : nums){
            if(vis[n])
                return n;
            vis[n] = 1;
        }

        return -1;
    }
};