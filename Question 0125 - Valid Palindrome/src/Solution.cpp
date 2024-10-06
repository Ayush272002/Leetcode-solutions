#include <bits/stdc++.h>
using namespace std;

string getWords(string &s)
{
    string ans = "";
    for (int i = 0; i < s.size(); i++)
    {
        if (isalnum(s[i]))
        {
            ans += tolower(s[i]);
        }
    }

    return ans;
}

class Solution
{
public:
    bool isPalindrome(string s)
    {
        string s1 = getWords(s);
        string s2 = s1;
        reverse(s2.begin(), s2.end());
        return s1 == s2;
    }
};