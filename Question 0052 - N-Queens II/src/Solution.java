import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution
{
    private boolean isSafe(char[][] board, int row, int col, int n)
    {
        //row check
        for (int i = 0; i < col; i++) {
            if(board[row][i] == 'Q') return false;
        }

        //upper left diagonal
        for(int i = row, j = col; i >= 0 && j >= 0; i--,j--)
        {
            if(board[i][j] == 'Q') return false;
        }

        //lower diagonal
        for(int i = row, j = col; i<n && j >=0; i++,j--)
        {
            if(board[i][j] == 'Q') return false;
        }

        return true;
    }
    private void solve(char[][] board, List<List<String>> ans, int col, int n)
    {
        //base case
        if(col == n)
        {
            List<String> temp = new ArrayList<>();
            for(char[] b : board)
                temp.add(new String(b));


            ans.add(temp);
            return;
        }

        for (int row = 0; row < n; row++) {
            if(isSafe(board,row,col,n))
            {
                board[row][col] = 'Q';
                solve(board, ans, col+1, n);
                board[row][col] = '.';
            }
        }
    }
    public int totalNQueens(int n)
    {
        char[][] board = new char[n][n];
        for(char[] r : board)
            Arrays.fill(r,'.');

        List<List<String>> ans = new ArrayList<>();
        solve(board,ans,0,n);
        return ans.size();
    }
}