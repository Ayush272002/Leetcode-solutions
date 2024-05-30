#include<bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int maxArea(vector<int>& height)
    {
        int n = height.size();

        int left = 0, right = n-1, ans = INT_MIN;
        while(left < right)
        {
            int minHeight = min(height[left], height[right]);
            ans = max(ans, minHeight*(right-left));
            while(left < right && height[left] <= minHeight) left++;
            while(left < right && height[right] <= minHeight) right--;
        }

        return ans;
    }
};