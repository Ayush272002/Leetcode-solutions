#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    bool isPalindrome(string &word)
    {
        int start = 0, end = word.size() - 1;

        while (start < end)
        {
            if (word[start] != word[end])
                return false;

            start++;
            end--;
        }

        return true;
    }

public:
    vector<vector<int>> palindromePairs(vector<string> &words)
    {
        vector<vector<int>> ans;

        int n = words.size();
        unordered_map<string, int> mp;

        for (int i = 0; i < n; i++)
        {
            string s = words[i];
            reverse(s.begin(), s.end());
            mp[s] = i;
        }

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j <= words[i].size(); j++)
            {
                string prefix = words[i].substr(0, j);
                string sufix = words[i].substr(j);

                if (mp.count(prefix) && isPalindrome(sufix) && mp[prefix] != i)
                    ans.push_back({i, mp[prefix]});

                if (!prefix.empty() && mp.count(sufix) && isPalindrome(prefix) && mp[sufix] != i)
                    ans.push_back({mp[sufix], i});
            }
        }

        return ans;
    }
};