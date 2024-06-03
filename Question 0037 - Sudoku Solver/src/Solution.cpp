#include<bits/stdc++.h>
using namespace std;

bool isSafe(int row, int col, vector<vector<char>>& board, int value)
{
    int n = board[0].size();
    for(int i = 0; i < n; i++)
    {
        //row check
        if(board[row][i] == value) return false;

        //col check
        if(board[i][col] == value) return false;

        //3 x 3 matrix
        if(board[3* (row/3) + i/3][3*(col/3) + i%3] == value) return false;
    }

    return true;
}

bool solve(vector<vector<char>>& board)
{
    int n = board[0].size();
    for(int row = 0; row < n; row++)
    {
        for(int col = 0; col < n; col++)
        {
            if(board[row][col] == '.')
            {
                for(int val = '1'; val <= '9'; val++)
                {
                    if(isSafe(row, col, board, val))
                    {
                        board[row][col] = val;
                        //recursive call
                        bool furtherPossible = solve(board);
                        if(furtherPossible) return true;
                        else
                        {
                            //backtrack
                            board[row][col] = '.';
                        }
                    }
                }

                return false;
            }
        }
    }

    return true;
}

class Solution 
{
public:
    void solveSudoku(vector<vector<char>>& board) 
    {
        solve(board);
    }
};