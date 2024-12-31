#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int hIndex(vector<int> &citations)
    {
        sort(citations.begin(), citations.end());

        int h = 0;
        for (int i = 0; i < citations.size(); i++)
        {
            if (citations[i] >= citations.size() - i)
            {
                h = citations.size() - i;
                break;
            }
        }

        return h;
    }
};