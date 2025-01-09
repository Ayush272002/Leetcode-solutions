#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    bool isPrefixAndSuffix(string &str1, string &str2)
    {
        if (str1.size() > str2.size())
            return false;
        return str1 == str2.substr(0, str1.size()) && str1 == str2.substr(str2.size() - str1.size(), str1.size());
    }

public:
    int countPrefixSuffixPairs(vector<string> &words)
    {
        int ans = 0;
        for (int i = 0; i < words.size(); i++)
        {
            for (int j = i + 1; j < words.size(); j++)
            {
                if (i == j)
                    continue;
                if (isPrefixAndSuffix(words[i], words[j]))
                    ans++;
            }
        }

        return ans;
    }
}; 