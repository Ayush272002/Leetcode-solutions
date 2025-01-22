#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int firstCompleteIndex(vector<int> &arr, vector<vector<int>> &mat)
    {
        unordered_map<int, int> rowPos, colPos, rowCount, colCount;
        int m = mat.size(), n = mat[0].size();

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                rowPos[mat[i][j]] = i;
                colPos[mat[i][j]] = j;
            }
        }

        for (int i = 0; i < arr.size(); i++)
        {
            int val = arr[i];
            rowCount[rowPos[val]]++;
            colCount[colPos[val]]++;

            if (rowCount[rowPos[val]] == n || colCount[colPos[val]] == m)
                return i;
        }

        return -1;
    }
};