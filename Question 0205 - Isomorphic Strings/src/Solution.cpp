#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    bool isIsomorphic(string s, string t)
    {
        unordered_map<char, char> s_to_t, t_to_s;

        for (int i = 0; i < s.size(); i++)
        {
            char c1 = s[i], c2 = t[i];

            if (s_to_t.count(c1))
            {
                if (s_to_t[c1] != c2)
                    return false;
            }
            else
            {
                if (t_to_s.count(c2) && t_to_s[c2] != c1)
                    return false;

                s_to_t[c1] = c2;
                t_to_s[c2] = c1;
            }
        }

        return true;
    }
};