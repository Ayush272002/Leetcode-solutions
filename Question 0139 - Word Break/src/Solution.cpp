#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    bool solve(string &s, vector<string> &wordDict, int idx, vector<int> &dp)
    {
        // base case
        if (idx == s.size())
            return true;

        if (dp[idx] != -1)
            return dp[idx];

        for (auto &w : wordDict)
        {
            int len = w.size();

            if (s.substr(idx, len) == w)
            {
                if (solve(s, wordDict, idx + len, dp))
                    return dp[idx] = true;
            }
        }

        return dp[idx] = false;
    }

public:
    bool wordBreak(string s, vector<string> &wordDict)
    {
        vector<int> dp(s.size(), -1);
        return solve(s, wordDict, 0, dp);
    }
};