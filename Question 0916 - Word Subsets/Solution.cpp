#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    vector<int> count(const string &s)
    {
        vector<int> arr(26, 0);
        for (char c : s)
            arr[c - 'a']++;

        return arr;
    }

public:
    vector<string> wordSubsets(vector<string> &words1, vector<string> &words2)
    {
        vector<int> freq2(26, 0);
        for (const string &b : words2)
        {
            vector<int> bcount = count(b);
            for (int i = 0; i < 26; i++)
                freq2[i] = max(bcount[i], freq2[i]);
        }

        vector<string> ans;
        for (const string &a : words1)
        {
            vector<int> acount = count(a);
            bool isSubset = true;
            for (int i = 0; i < 26; i++)
            {
                if (acount[i] < freq2[i])
                {
                    isSubset = false;
                    break;
                }
            }
            if (isSubset)
                ans.push_back(a);
        }

        return ans;
    }
};