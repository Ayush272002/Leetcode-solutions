#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    vector<int> sortedSquares(vector<int> &nums)
    {
        // for (int i = 0; i < nums.size(); i++)
        // {
        //     nums[i] *= nums[i];
        // }

        // sort(nums.begin(), nums.end());
        // return nums;

        int left = 0, right = nums.size() - 1;
        int idx = right;
        vector<int> ans(nums.size());

        while (left <= right)
        {
            if (abs(nums[right]) > abs(nums[left]))
            {
                ans[idx] = nums[right] * nums[right];
                right--;
            }
            else
            {
                ans[idx] = nums[left] * nums[left];
                left++;
            }

            idx--;
        }

        return ans;
    }
};