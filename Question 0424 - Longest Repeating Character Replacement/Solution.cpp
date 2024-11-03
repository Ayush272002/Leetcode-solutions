#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int characterReplacement(string s, int k)
    {
        int maxLen = 0, maxFreq = 0;
        int l = 0, r = 0;

        vector<int> map(26, 0);

        while (r < s.size())
        {
            map[s[r] - 'A']++;
            maxFreq = max(maxFreq, map[s[r] - 'A']);

            while ((r - l + 1) - maxFreq > k)
            {
                map[s[l] - 'A']--;
                maxFreq = 0;
                for (int i = 0; i < map.size(); i++)
                {
                    maxFreq = max(maxFreq, map[i]);
                }
                l++;
            }

            if ((r - l + 1) - maxFreq <= k)
            {
                maxLen = max(maxLen, r - l + 1);
            }
            r++;
        }

        return maxLen;
    }
};