#include<bits/stdc++.h>
using namespace std;

class Solution 
{
public:
    vector<int> searchRange(vector<int>& nums, int target) 
    {
        int left = -1, right = -1;
        int l = 0, r = nums.size()-1;

        while(l <= r)
        {
            int mid = l + (r-l)/2;

            if(nums[mid] >= target)
            {
                if(nums[mid] == target) left = mid;
                r = mid-1;
            }
            else l = mid+1;
        }

        l = 0, r = nums.size()-1;
        while(l <= r)
        {
            int mid = l + (r-l)/2;

            if(nums[mid] <= target)
            {
                if(nums[mid] == target) right = mid;
                l = mid+1;
            }
            else r = mid-1;
        }

        return {left, right};
    }
};