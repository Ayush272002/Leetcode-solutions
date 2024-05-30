#include <bits/stdc++.h>
using namespace std;

void solve(vector<string> &ans, unordered_map<char, string> &map, string digits, int idx, string &curr)
{
    if (idx >= digits.size())
    {if(curr.empty()) return;
        ans.push_back(curr);
        return;
    }

    string letter = map[digits[idx]];
    for (int j = 0; j < letter.size(); j++)
    {
        curr.push_back(letter[j]);
        solve(ans, map, digits, idx + 1, curr);
        curr.pop_back();
    }
}

class Solution
{
public:
    vector<string> letterCombinations(string digits)
    {
        unordered_map<char, string> map;
        map['2'] = "abc";
        map['3'] = "def";
        map['4'] = "ghi";
        map['5'] = "jkl";
        map['6'] = "mno";
        map['7'] = "pqrs";
        map['8'] = "tuv";
        map['9'] = "wxyz";

        vector<string> ans;
        string curr = "";

        solve(ans, map, digits, 0, curr);
        return ans;
    }
};