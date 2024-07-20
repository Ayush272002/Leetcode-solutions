#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    static bool cmp(const vector<int> &a, const vector<int> &b)
    {
        return a[0] < b[0];
    }

public:
    vector<vector<int>> merge(vector<vector<int>> &intervals)
    {
        sort(intervals.begin(), intervals.end(), cmp);

        vector<vector<int>> ans;

        for (auto &interval : intervals)
        {
            if (ans.empty())
                ans.push_back(interval);

            else
            {
                vector<int> last = ans.back();

                if (last[1] >= interval[0])
                {
                    last[1] = max(last[1], interval[1]);
                    ans.pop_back();
                    ans.push_back(last);
                }
                else
                {
                    ans.push_back(interval);
                }
            }
        }

        return ans;
    }
};