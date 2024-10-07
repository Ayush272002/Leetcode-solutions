#include <bits/stdc++.h>
using namespace std;

class Solution
{
    bool canEat(vector<int> &piles, int h, int k)
    {
        int hrs = 0;

        for (int pile : piles)
        {
            hrs += (pile + k - 1) / k;
            if (hrs > h)
                return false;
        }

        return true;
    }

public:
    int minEatingSpeed(vector<int> &piles, int h)
    {
        int l = 1, r = *max_element(piles.begin(), piles.end());

        while (l < r)
        {
            int mid = l + (r - l) / 2;
            if (canEat(piles, h, mid))
            {
                r = mid;
            }
            else
            {
                l = mid + 1;
            }
        }

        return l;
    }
};