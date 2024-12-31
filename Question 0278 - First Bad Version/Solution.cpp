#include <bits/stdc++.h>
using namespace std;
// The API isBadVersion is defined for you.
// bool isBadVersion(int version);

class Solution
{
public:
    int firstBadVersion(int n)
    {
        int l = 1, r = n;

        int mid = l + (r - l) / 2;

        while (l <= r)
        {
            bool res = isBadVersion(mid);

            if (!res)
            {
                l = mid + 1;
            }
            else
            {
                r = mid - 1;
            }

            mid = l + (r - l) / 2;
        }

        return mid;
    }
};