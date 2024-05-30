#include<bits/stdc++.h>
using namespace std;

class Solution 
{
public:
    
    string longestPalindrome(string s) 
    {
        int n = s.size();
        if(n <= 1) return s;

        vector<vector<bool>> dp(n, vector<bool>(n, false));
        int maxLen = 1, start = 0, end = 0;

        for(int i = n-1; i >= 0; i--)
        {
            dp[i][i] = true;
            for(int j = i+1; j < n; j++)
            {
                if(s[i] == s[j] && (j - i <= 2 || dp[i+1][j-1]))
                {
                    dp[i][j] = true;
                    if(j - i + 1 > maxLen)
                    {
                        maxLen = j - i + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substr(start, end - start + 1);
    }
};