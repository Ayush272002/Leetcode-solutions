#include <bits/stdc++.h>
using namespace std;

// class Solution
// {
// public:
//     long long maximumSubarraySum(vector<int> &nums, int k)
//     {
//         long long ans = 0;
//         int n = nums.size();
//         for (int i = 0; i <= n - k; i++)
//         {
//             long long sum = 0;
//             unordered_set<int> elements;
//             bool isDistinct = true;
//             for (int j = i; j < i + k; j++)
//             {
//                 if (elements.find(nums[j]) != elements.end())
//                 {
//                     isDistinct = false;
//                     break;
//                 }
//                 elements.insert(nums[j]);
//                 sum += nums[j];
//             }

//             if (isDistinct)
//                 ans = max(ans, sum);
//         }

//         return ans;
//     }
// };

class Solution
{
public:
    long long maximumSubarraySum(vector<int> &nums, int k)
    {
        long long ans = 0, sum = 0;
        unordered_map<int, int> freq;
        int n = nums.size();

        for (int i = 0, j = 0; j < n; j++)
        {
            sum += nums[j];
            freq[nums[j]]++;

            while (j - i + 1 > k)
            {
                sum -= nums[i];
                freq[nums[i]]--;
                if (freq[nums[i]] == 0)
                    freq.erase(nums[i]);

                i++;
            }

            if (j - i + 1 == k && freq.size() == k)
                ans = max(ans, sum);
        }

        return ans;
    }
};