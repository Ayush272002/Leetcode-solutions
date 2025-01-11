#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    string convert(string s, int numRows)
    {
        if (numRows <= 1)
            return s;

        string ans = "";

        for (int r = 0; r < numRows; r++)
        {
            int increment = 2 * (numRows - 1);

            for (int i = r; i < s.size(); i += increment)
            {
                ans += s[i];
                if (r > 0 && r < numRows - 1 && i + increment - 2 * r < s.size())
                {
                    ans += s[i + increment - 2 * r];
                }
            }
        }

        return ans;
    }
};