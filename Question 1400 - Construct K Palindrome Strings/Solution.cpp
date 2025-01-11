#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    bool canConstruct(string s, int k)
    {
        if (s.size() < k)
            return false;

        vector<int> freq(26, 0);
        for (char ch : s)
            freq[ch - 'a']++;

        int oddCount = 0;
        for (int i = 0; i < freq.size(); i++)
        {
            if (freq[i] & 1 == 1)
                oddCount++;
        }

        return oddCount <= k;
    }
};