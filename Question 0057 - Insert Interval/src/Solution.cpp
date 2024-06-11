#include<bits/stdc++.h>
using namespace std;

bool cmp(vector<int>& a, vector<int>& b)
{
    return a[0] < b[0];
}

class Solution 
{
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) 
    {
        intervals.push_back(newInterval);
        sort(intervals.begin(), intervals.end(), cmp);

        vector<vector<int>> ans;
        for(auto& i : intervals)
        {
            if(ans.empty() || ans.back()[1] < i[0]) ans.push_back(i);
            else ans.back()[1] = max(ans.back()[1], i[1]);
        }

        return ans;
    }
};