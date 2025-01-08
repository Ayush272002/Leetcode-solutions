#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

class Solution
{
private:
    ll distance(vector<int> &p1, vector<int> &p2)
    {
        ll xsq = (p1[0] - p2[0]) * (p1[0] - p2[0]);
        ll ysq = (p1[1] - p2[1]) * (p1[1] - p2[1]);

        return xsq + ysq;
    }

public:
    bool validSquare(vector<int> &p1, vector<int> &p2, vector<int> &p3, vector<int> &p4)
    {
        vector<ll> dst;

        dst.push_back(distance(p1, p2));
        dst.push_back(distance(p1, p3));
        dst.push_back(distance(p1, p4));
        dst.push_back(distance(p2, p3));
        dst.push_back(distance(p2, p4));
        dst.push_back(distance(p3, p4));

        sort(dst.begin(), dst.end());

        return dst[0] > 0 && dst[0] == dst[1] && dst[1] == dst[2] && dst[2] == dst[3] &&
               dst[4] == dst[5] && dst[4] == 2 * dst[0];
    }
};