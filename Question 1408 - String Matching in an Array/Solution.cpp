#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    vector<string> stringMatching(vector<string> &words)
    {
        vector<string> ans;

        for (int i = 0; i < words.size(); i++)
        {
            for (int j = 0; j < words.size(); j++)
            {
                if (words[i] != words[j])
                {
                    if (words[i].find(words[j]) != string::npos && find(ans.begin(), ans.end(), words[j]) == ans.end())
                        ans.push_back(words[j]);
                }
            }
        }

        return ans;
    }
};