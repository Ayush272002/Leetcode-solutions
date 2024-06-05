#include<bits/stdc++.h>
using namespace std;

class Solution 
{
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) 
    {
        map<string, vector<string>> map;
        for(auto s : strs)
        {
            string letters = s;
            sort(letters.begin(), letters.end());
            map[letters].push_back(s);
        }

        vector<vector<string>> ans;
        for(auto& val : map)
        {
            ans.push_back(val.second);
        }

        return ans;
    }
};