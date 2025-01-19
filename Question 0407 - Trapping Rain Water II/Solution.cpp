#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    class Cell
    {
        int height, row, col;

    public:
        Cell(int h, int r, int c) : height(h), row(r), col(c) {}
        int getHeight() const { return height; }
        int getRow() const { return row; }
        int getCol() const { return col; }
        bool operator<(const Cell &other) const { return height > other.height; }
    };

public:
    int trapRainWater(vector<vector<int>> &heightMap)
    {
        int rows = heightMap.size(), cols = heightMap[0].size(), water = 0;
        vector<vector<bool>> visited(rows, vector<bool>(cols, false));
        priority_queue<Cell> pq;

        for (int i = 0; i < rows; i++)
        {
            pq.push(Cell(heightMap[i][0], i, 0));
            pq.push(Cell(heightMap[i][cols - 1], i, cols - 1));
            visited[i][0] = visited[i][cols - 1] = true;
        }

        for (int j = 0; j < cols; j++)
        {
            pq.push(Cell(heightMap[0][j], 0, j));
            pq.push(Cell(heightMap[rows - 1][j], rows - 1, j));
            visited[0][j] = visited[rows - 1][j] = true;
        }

        vector<vector<int>> dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!pq.empty())
        {
            Cell curr = pq.top();
            pq.pop();

            for (auto &d : dir)
            {
                int r = curr.getRow() + d[0];
                int c = curr.getCol() + d[1];

                if (r >= 0 && r < rows && c >= 0 && c < cols && !visited[r][c])
                {
                    water += max(0, curr.getHeight() - heightMap[r][c]);
                    pq.push(Cell(max(heightMap[r][c], curr.getHeight()), r, c));
                    visited[r][c] = true;
                }
            }
        }

        return water;
    }
};