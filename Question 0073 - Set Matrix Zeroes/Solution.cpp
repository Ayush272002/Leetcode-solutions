#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    void setColumnToZero(vector<vector<int>> &matrix, int col)
    {
        for (int i = 0; i < matrix.size(); ++i)
        {
            if (col < matrix[i].size())
            {
                matrix[i][col] = 0;
            }
        }
    }

public:
    void setZeroes(vector<vector<int>> &matrix)
    {
        vector<int> row(matrix.size(), 0);
        vector<int> col(matrix[0].size(), 0);

        for (int i = 0; i < matrix.size(); i++)
        {
            for (int j = 0; j < matrix[0].size(); j++)
            {
                if (matrix[i][j] == 0)
                {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < row.size(); i++)
        {
            if (row[i] == 1)
            {
                fill(matrix[i].begin(), matrix[i].end(), 0);
            }
        }

        for (int i = 0; i < col.size(); i++)
        {
            if (col[i] == 0)
            {
                setColumnToZero(matrix, i);
            }
        }
    }
};