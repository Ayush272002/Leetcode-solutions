#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int maxScore(string s)
    {
        vector<int> zero(s.size()), one(s.size());

        int count = 0;
        for (int i = 0; i < s.size(); i++)
        {
            if (s[i] == '0')
                count++;
            zero[i] = count;
        }

        count = 0;
        for (int i = s.size() - 1; i >= 0; i--)
        {
            if (s[i] == '1')
                count++;
            one[i] = count;
        }

        int ans = INT_MIN;

        for (int i = 0; i < s.size() - 1; i++)
            ans = max(ans, zero[i] + one[i + 1]);

        return ans;
    }
};