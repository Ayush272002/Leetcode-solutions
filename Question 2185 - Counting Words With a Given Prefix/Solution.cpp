#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int prefixCount(vector<string> &words, string pref)
    {
        int count = 0;

        for (int i = 0; i < words.size(); i++)
        {
            if (pref.size() > words[i].size())
                continue;

            if (pref == words[i].substr(0, pref.size()))
                count++;
        }

        return count;
    }
};