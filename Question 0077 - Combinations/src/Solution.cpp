#include<bits/stdc++.h>
using namespace std;

void solve(int n, int k, vector<int>& curr, vector<vector<int>>& ans, int start)
{
    if(curr.size() == k)
    {
        ans.push_back(curr);
        return;
    }

    for(int i = start; i <= n; i++)
    {
        curr.push_back(i);
        solve(n, k, curr, ans, i+1);
        curr.pop_back();
    }
}

class Solution 
{
public:
    vector<vector<int>> combine(int n, int k) 
    {
        vector<vector<int>> ans;
        vector<int> curr;
        solve(n, k, curr, ans, 1);
        return ans;
    }
};