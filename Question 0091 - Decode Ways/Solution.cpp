#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    int solve(string &s, int idx, vector<int> &dp)
    {
        if (idx == s.size())
            return 1;

        if (s[idx] == '0')
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        // take 1
        int res = solve(s, idx + 1, dp);

        // take 2
        if (idx + 1 < s.size())
        {
            string two = s.substr(idx, 2);
            int num = stoi(two);

            if (num >= 10 && num <= 26)
                res += solve(s, idx + 2, dp);
        }

        return dp[idx] = res;
    }

public:
    int numDecodings(string s)
    {
        vector<int> dp(s.size() + 1, -1);
        return solve(s, 0, dp);
    }
};