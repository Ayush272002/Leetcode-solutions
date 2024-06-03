#include <bits/stdc++.h>
using namespace std;
#define pb push_back
#define vvi vector<vector<int>>
#define vi vector<int>

void solve(vi& candidates, vvi& ans, vi& combi, int target, int idx)
{
    if(target == 0)
    {
        ans.pb(combi);
        return;
    }

    for(int i = idx; i < candidates.size(); i++)
    {
        if(i > idx && candidates[i] == candidates[i-1]) continue;

        if(candidates[i] <= target)
        {
            combi.pb(candidates[i]);
            solve(candidates, ans, combi, target-candidates[idx], idx+1);
            combi.pop_back();
        }
    }
    
}

class Solution 
{
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) 
    {
        vvi ans;
        vi combi;
        sort(candidates.begin(), candidates.end());
        solve(candidates, ans, combi, target, 0);
        return ans;
    }
};