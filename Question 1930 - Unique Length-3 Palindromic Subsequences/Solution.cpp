#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    bool palindrome(string &s)
    {
        int l = 0, r = s.size() - 1;

        while (l < r)
        {
            if (s[l] != s[r])
                return false;

            l++;
            r--;
        }

        return true;
    }

    void solve(string &s, int idx, int len, string &curr, set<string> &st)
    {
        if (len == 3)
        {
            if (palindrome(curr))
                st.insert(curr);

            return;
        }
        if (idx >= s.size())
            return;

        curr.push_back(s[idx]);
        solve(s, idx + 1, len + 1, curr, st);
        curr.pop_back();

        solve(s, idx + 1, len, curr, st);
    }

public:
    int countPalindromicSubsequence(string s)
    {
        // string curr = "";
        // set<string> st;
        // solve(s, 0, 0, curr, st);
        // return st.size();

        unordered_map<char, pair<int, int>> mp;

        for (char c = 'a'; c <= 'z'; c++)
            mp[c] = {-1, -1};

        for (int i = 0; i < s.size(); i++)
        {
            if (mp[s[i]].first == -1)
                mp[s[i]].first = i;
        }

        for (int i = s.size() - 1; i >= 0; i--)
        {
            if (mp[s[i]].second == -1)
                mp[s[i]].second = i;
        }

        int ans = 0;
        for (auto &it : mp)
        {
            int start = it.second.first, end = it.second.second;
            set<int> st;

            for (int i = start + 1; i < end; i++)
                st.insert(s[i]);

            ans += st.size();
        }

        return ans;
    }
};