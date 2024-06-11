#include<bits/stdc++.h>
using namespace std;

class Solution 
{
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) 
    {
        if(matrix.size() == 0) return false;

        int c = matrix[0].size();
        int l = 0, r = matrix.size()*c - 1;

        while(l <= r)
        {
            int pos = r + (l-r)/2;
            int mid = matrix[pos/c][pos%c];
            if(mid == target) return true;
            else if(mid < target) l = pos + 1;
            else r = pos - 1;
        }

        return false;
    }
};