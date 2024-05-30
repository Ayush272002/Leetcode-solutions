#include<bits/stdc++.h>
using namespace std;

void solve(vector<string> &ans, string &curr, int start, int close)
{
    if(start == 0 && close == 0)
    {
        ans.push_back(curr);
        return;
    }

    if(start > 0)
    {
        curr += "(";
        solve(ans, curr, start-1, close);
        curr.pop_back();
    }
    if(close > start)
    {
        curr += ")";
        solve(ans, curr, start, close-1);
        curr.pop_back();
    }
}

class Solution 
{
public:
    vector<string> generateParenthesis(int n) 
    {
        vector<string> ans;
        string curr = "";
        solve(ans, curr, n, n);
        return ans;
    }
};