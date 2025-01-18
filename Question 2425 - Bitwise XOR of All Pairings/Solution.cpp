#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int xorAllNums(vector<int> &nums1, vector<int> &nums2)
    {
        vector<int> ans;

        int m = nums2.size(), xorNums1 = 0;
        if (m & 1)
        {
            for (int i = 0; i < nums1.size(); i++)
                xorNums1 = xorNums1 ^ nums1[i];
        }

        int n = nums1.size(), xorNums2 = 0;
        if (n & 1)
        {
            for (int i = 0; i < nums2.size(); i++)
                xorNums2 = xorNums2 ^ nums2[i];
        }

        return xorNums1 ^ xorNums2;
    }
};