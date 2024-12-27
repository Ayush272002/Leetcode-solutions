#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    bool checkInclusion(string s1, string s2)
    {
        if (s1.size() > s2.size())
            return false;

        vector<int> s1Freq(26, 0), s2Freq(26, 0);

        for (int i = 0; i < s1.size(); i++)
        {
            s1Freq[s1[i] - 'a']++;
        }

        int windowSize = s1.size();
        for (int i = 0; i < s2.size(); i++)
        {
            s2Freq[s2[i] - 'a']++;

            if (i >= windowSize)
            {
                s2Freq[s2[i - windowSize] - 'a']--;
            }

            if (s1Freq == s2Freq)
                return true;
        }

        return false;
    }
};