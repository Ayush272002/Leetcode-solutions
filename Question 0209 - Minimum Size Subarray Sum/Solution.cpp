#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int minSubArrayLen(int target, vector<int> &nums)
    {
        int len = INT_MAX, curr = 0;

        int left = 0;

        for (int right = 0; right < nums.size(); right++)
        {
            curr += nums[right];

            while (curr >= target)
            {
                len = min(len, right - left + 1);
                curr -= nums[left++];
            }
        }

        return len == INT_MAX ? 0 : len;
    }
};