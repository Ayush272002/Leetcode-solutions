#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int numIdenticalPairs(vector<int> &nums)
    {
        unordered_map<int, int> mp;

        for (int i = 0; i < nums.size(); i++)
        {
            mp[nums[i]]++;
        }

        int ans = 0;

        for (const auto &p : mp)
        {
            ans += ((p.second) * (p.second - 1) % 2);
        }

        return ans;
    }
};