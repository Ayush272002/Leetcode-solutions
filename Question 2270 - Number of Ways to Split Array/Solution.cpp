#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int waysToSplitArray(vector<int> &nums)
    {
        long long sum = accumulate(nums.begin(), nums.end(), 0LL);
        long long left = 0;
        int count = 0;

        for (int i = 0; i < nums.size() - 1; i++)
        {
            left += nums[i];
            long long right = sum - left;

            if (left >= right)
                count++;
        }

        return count;
    }
};