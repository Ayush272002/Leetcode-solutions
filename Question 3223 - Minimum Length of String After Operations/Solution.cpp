#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int minimumLength(string s)
    {
        unordered_map<char, int> mp;
        int ans = s.size();
        for (char ch : s)
        {
            mp[ch]++;
            if (mp[ch] > 2)
            {
                mp[ch] = 1;
                ans -= 2;
            }
        }

        return ans;
    }
};