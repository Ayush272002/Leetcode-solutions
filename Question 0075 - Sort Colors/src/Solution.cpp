#include<bits/stdc++.h>
using namespace std;

class Solution 
{
public:
    void sortColors(vector<int>& nums) 
    {
        int n = nums.size() - 1;
        int i = 0, p = 0;

        while(i <= n)
        {
            if(nums[i] == 0)
            {
                swap(nums[p], nums[i]);
                p++;
                i++;
            }
            else if(nums[i] == 2)
            {
                swap(nums[n], nums[i]);
                n--;
            }
            else i++;
        }
    }
};