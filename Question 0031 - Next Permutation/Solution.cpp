#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    int findIndex(vector<int> &nums, int i)
    {
        for (int j = nums.size() - 1; j > i - 1; j--)
            if (nums[j] > nums[i-1])
                return j;

        return i;
    }

public:
    void nextPermutation(vector<int> &nums)
    {
        for (int i = nums.size() - 1; i >= 1; i--)
        {
            if (nums[i - 1] < nums[i])
            {
                int k = findIndex(nums, i);
                swap(nums[i - 1], nums[k]);
                sort(nums.begin() + i, nums.end());
                return;
            }
        }

        sort(nums.begin(), nums.end());
    }
};