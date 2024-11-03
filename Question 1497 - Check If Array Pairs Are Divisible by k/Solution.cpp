#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    bool canArrange(vector<int> &arr, int k)
    {
        unordered_map<int, int> map;
        for (auto a : arr)
        {
            map[(a % k + k) % k]++;
        }

        if (map[0] % 2 == 1)
            return false;

        for (int i = 1; i < k; i++)
        {
            if (map[i] != map[k - i])
                return false;
        }

        return true;
    }
};