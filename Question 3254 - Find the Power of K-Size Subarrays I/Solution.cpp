#include<bits/stdc++.h>
using namespace std;

class Solution
{
public:
    vector<int> resultsArray(vector<int> &nums, int k)
    {
        vector<int> res(nums.size() - k + 1, -1);

        for (int i = 0; i <= nums.size() - k; i++)
        {
            bool isConsecutive = true;
            for (int j = i; j < i + k - 1; j++)
            {
                if (nums[j + 1] - nums[j] != 1)
                {
                    isConsecutive = false;
                    break;
                }
            }

            if (isConsecutive)
            {
                res[i] = nums[i + k - 1];
            }
        }

        return res;
    }
};