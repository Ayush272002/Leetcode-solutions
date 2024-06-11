#include<bits/stdc++.h>
using namespace std;

bool solve(vector<vector<char>>& board, string& word, int i, int j, vector<vector<int>>& dir, int idx)
{
    if(board[i][j] != word[idx]) return false;
    if(idx == word.size() - 1) return true;
    char temp = board[i][j];
    board[i][j] = '#';

    for(auto& d : dir)
    {
        int x = i + d[0];
        int y = j + d[1];

        if(x >= 0 && x < board.size() && y >= 0 && y < board[0].size())
        {
            if (solve(board, word, x, y, dir, idx+1)) return true;
        }
    }

    board[i][j] = temp;
    return false;
}

class Solution 
{
public:
    bool exist(vector<vector<char>>& board, string word) 
    {
        int r = board.size(), c = board[0].size();
        vector<vector<int>> dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                if(solve(board, word, i, j, dir, 0)) return true;
            }
        }

        return false;
    }
};