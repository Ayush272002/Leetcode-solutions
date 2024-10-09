#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int findMin(vector<int> &nums)
    {
        int l = 0, r = nums.size() - 1;
        int mid = l + (r - l) / 2;

        while (l < r)
        {
            if (mid > 0 && nums[mid] < nums[mid - 1])
                return nums[mid];

            if (nums[mid] < nums[r])
            {
                r = mid;
            }
            else
            {
                l = mid + 1;
            }
            mid = l + (r - l) / 2;
        }

        return nums[l];
    }
};