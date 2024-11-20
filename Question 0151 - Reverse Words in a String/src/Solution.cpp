#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    string reverseWords(string s)
    {
        vector<string> words;
        stringstream ss(s);
        string word;
        while (ss >> word)
            words.push_back(word);

        reverse(words.begin(), words.end());
        string ans;
        for (const auto &w : words)
        {
            ans += w + ' ';
        }

        if (!ans.empty())
            ans.pop_back();

        return ans;
    }
};