#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    void dfs(vector<vector<char>> &board, vector<vector<bool>> &vis, vector<vector<int>> &dir, int r, int c)
    {
        if (r < 0 || r >= board.size() || c < 0 || c >= board[0].size() || vis[r][c] || board[r][c] == 'X')
            return;

        vis[r][c] = true;

        for (auto &d : dir)
        {
            int x = r + d[0];
            int y = c + d[1];

            dfs(board, vis, dir, x, y);
        }
    }

public:
    void solve(vector<vector<char>> &board)
    {
        int n = board.size(), m = board[0].size();

        vector<vector<bool>> vis(n, vector<bool>(m, false));

        vector<vector<int>> dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int row = 0; row < n; row++)
        {
            if (!vis[row][0] && board[row][0] == 'O')
                dfs(board, vis, dir, row, 0);

            if (!vis[row][m - 1] && board[row][m - 1] == 'O')
                dfs(board, vis, dir, row, m - 1);
        }

        for (int col = 0; col < m; col++)
        {
            if (!vis[0][col] && board[0][col] == 'O')
                dfs(board, vis, dir, 0, col);

            if (!vis[n - 1][col] && board[n - 1][col] == 'O')
                dfs(board, vis, dir, n - 1, col);
        }

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (!vis[i][j] && board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }
};