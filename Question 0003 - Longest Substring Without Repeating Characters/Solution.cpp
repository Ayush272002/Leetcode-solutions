#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int lengthOfLongestSubstring(string s)
    {
        if (s.empty())
            return 0;

        int len = 1;

        for (int i = 0; i < s.size(); i++)
        {
            set<char> st;
            int currLen = 0;
            for (int j = i; j < s.size(); j++)
            {
                auto res = st.insert(s[j]);
                if (res.second)
                    currLen++;
                else
                    break;
            }

            len = max(len, currLen);
        }

        return len;
    }
};