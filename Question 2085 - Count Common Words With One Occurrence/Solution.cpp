#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int countWords(vector<string> &words1, vector<string> &words2)
    {
        unordered_map<string, int> map1;
        unordered_map<string, int> map2;

        for (int i = 0; i < words1.size(); ++i)
        {
            map1[words1[i]]++;
        }

        for (int i = 0; i < words2.size(); i++)
        {
            map2[words2[i]]++;
        }

        int ans = 0;
        for (const auto &pair : map1)
        {
            const string &word = pair.first;
            int count1 = pair.second;

            if (count1 == 1 && map2[word] == 1)
                ans++;
        }

        return ans;
    }
};