#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    vector<int> findDiagonalOrder(vector<vector<int>> &mat)
    {
        vector<int> ans;
        if (mat.size() == 0)
            return ans;

        int n = mat.size(), m = mat[0].size();

        int rows = 0, cols = 0;
        bool up = true;
        while (rows < n && cols < m)
        {
            if (up)
            {
                while (rows > 0 && cols < m - 1)
                {
                    ans.push_back(mat[rows][cols]);
                    rows--;
                    cols++;
                }

                ans.push_back(mat[rows][cols]);
                if (cols == m - 1)
                    rows++;
                else
                    cols++;
            }
            else
            {
                while (cols > 0 && rows < n - 1)
                {

                    ans.push_back(mat[rows][cols]);
                    rows++;
                    cols--;
                }
                ans.push_back(mat[rows][cols]);
                if (rows == n - 1)
                    cols++;
                else
                    rows++;
            }

            up = !up;
        }

        return ans;
    }
};