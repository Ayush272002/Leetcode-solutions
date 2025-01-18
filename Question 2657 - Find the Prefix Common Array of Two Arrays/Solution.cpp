#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    vector<int> findThePrefixCommonArray(vector<int> &A, vector<int> &B)
    {
        vector<int> ans;
        vector<int> freq(A.size() + 1);

        int count = 0;
        for (int i = 0; i < A.size(); i++)
        {
            if (++freq[A[i]] == 2)
                count++;

            if (++freq[B[i]] == 2)
                count++;

            ans.push_back(count);
        }

        return ans;
    }
};