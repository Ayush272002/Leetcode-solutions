#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int shortestSubarray(vector<int> &nums, int k)
    {
        int n = nums.size();
        deque<pair<long long, long long>> dq;
        long long sum = 0;
        long long shortest = INT_MAX;

        for (long long i = 0; i < n; i++)
        {
            sum += nums[i];

            if (sum >= k)
                shortest = min(shortest, i + 1);

            // reduce the window size
            pair<long long, long long> curr = {INT_MIN, INT_MIN};
            while (!dq.empty() && (sum - dq.front().second >= k))
            {
                curr = dq.front();
                dq.pop_front();
            }

            if (curr.second != INT_MIN)
                shortest = min(shortest, (i - curr.first));

            while (!dq.empty() && sum <= dq.back().second)
                dq.pop_back();

            dq.push_back({i, sum});
        }

        return shortest == INT_MAX ? -1 : shortest;
    }
};