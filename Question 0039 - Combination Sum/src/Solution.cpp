#include<bits/stdc++.h>
using namespace std;

void solve(vector<vector<int>>& ans, vector<int>& combi, vector<int>& candidates, int target, int idx)
{
    if(target == 0)
    {
        ans.push_back(combi);
        return;
    }

    if(idx < 0 || target < 0) return;
    //take curr
    combi.push_back(candidates[idx]);
    solve(ans, combi, candidates, target-candidates[idx], idx);
    combi.pop_back();

    //exclude
    solve(ans, combi, candidates, target, idx-1);
}

class Solution 
{
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) 
    {
        vector<vector<int>> ans;
        vector<int> combi;
        solve(ans, combi, candidates, target, candidates.size()-1);
        return ans;
    }
};