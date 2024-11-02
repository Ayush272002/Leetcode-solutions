#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    string makeFancyString(string s)
    {
        string ans;

        int count = 1;
        ans.push_back(s[0]);
        for (int i = 1; i < s.size(); i++)
        {
            if (ans[ans.size() - 1] == s[i])
            {
                if (count == 2)
                {
                    continue;
                }
                else if (count < 2)
                {
                    ans.push_back(s[i]);
                    count++;
                }
            }
            else
            {
                ans.push_back(s[i]);
                count = 1;
            }
        }

        return ans;
    }
};