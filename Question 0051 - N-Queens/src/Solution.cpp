#include<bits/stdc++.h>
using namespace std;

bool isSafe(int row, int col, vector<vector<string>>& board, int n)
{
    int x = row;
    int y = col;

    //check for same row
    while(y >= 0)
    {
        if(board[x][y] == "Q") return false;
        y--;
    }

    x = row;
    y = col;

    //check for diagonal
    while(x >= 0 && y >= 0)
    {
        if(board[x][y] == "Q") return false;
        y--;
        x--;
    }

    x = row;
    y = col;

    //check for other diagonal
    while(x < n && y >= 0)
    {
        if(board[x][y] == "Q") return false;
        y--;
        x++;
    }

    return true;
}

void addSolution(vector<vector<string>>& board, vector<vector<string>>& ans, int n)
{
    vector<string> temp;
    for(int i = 0; i < n; i++)
    {
        string row = "";
        for(int j = 0; j < n; j++)
        {
            row += board[i][j];
        }
        temp.push_back(row);
    }

    ans.push_back(temp);
}

void solve(int col, vector<vector<string>>& ans, vector<vector<string>>& board, int n)
{
    //base case
    if(col == n) 
    {
        addSolution(board, ans, n);
        return;
    }

    //solve 1 case
    for(int row = 0; row < n; row++)
    {
        if(isSafe(row, col, board, n))
        {
            //if is safe
            board[row][col] = "Q";
            solve(col+1, ans, board, n);
            board[row][col] = ".";
        }
    }
}

class Solution 
{
public:
    vector<vector<string>> solveNQueens(int n) 
    {
        vector<vector<string>> board(n, vector<string>(n, "."));
        vector<vector<string>> ans;
        solve(0, ans, board, n);
        return ans;
    }
};