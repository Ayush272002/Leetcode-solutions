#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    vector<int> vowelStrings(vector<string> &words, vector<vector<int>> &queries)
    {
        vector<int> pf;
        static const set<char> vowels = {'a', 'e', 'i', 'o', 'u'};

        int count = 0;
        for (auto &w : words)
        {
            char s = w[0];
            char c = w[w.size() - 1];

            if (vowels.find(s) != vowels.end() && vowels.find(c) != vowels.end())
                count++;

            pf.push_back(count);
        }

        vector<int> ans;

        for (auto &q : queries)
            q[0] == 0 ? ans.push_back(pf[q[1]]) : ans.push_back(pf[q[1]] - pf[q[0] - 1]);

        return ans;
    }
};