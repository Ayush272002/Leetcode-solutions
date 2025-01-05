#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    static bool cmp(int &a, int &b)
    {
        string s1 = to_string(a);
        string s2 = to_string(b);

        return s1 + s2 > s2 + s1;
    }

public:
    string largestNumber(vector<int> &nums)
    {
        sort(nums.begin(), nums.end(), cmp);
        string ans = "";

        for (int &n : nums)
            ans += to_string(n);

        return ans[0] == '0' ? "0" : ans;
    }
};