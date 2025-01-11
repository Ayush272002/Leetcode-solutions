#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    string joinString(vector<string> &arr, string delimiter)
    {
        string ans;
        for (int i = 0; i < arr.size(); i++)
        {
            ans += arr[i];
            if (i + 1 < arr.size())
                ans += delimiter;
        }

        return ans;
    }

    void solve(string s, vector<string> &curr, vector<string> &ans, set<string> &st, int start)
    {
        if (start == s.size())
        {
            ans.push_back(joinString(curr, " "));
            return;
        }

        for (int i = start; i < s.size(); i++)
        {
            string word = s.substr(start, i - start + 1);

            if (st.count(word))
            {
                curr.push_back(word);
                solve(s, curr, ans, st, i + 1);
                curr.pop_back();
            }
        }
    }

public:
    vector<string> wordBreak(string s, vector<string> &wordDict)
    {
        set<string> st(wordDict.begin(), wordDict.end());
        vector<string> curr;
        vector<string> ans;
        solve(s, curr, ans, st, 0);
        return ans;
    }
};