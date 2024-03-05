import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class newSol
{
    private boolean isSafe(char[][] board, int r, int c, int n) {
        // Row check
        for (int i = 0; i < c; i++) {
            if (board[r][i] == 'Q') return false;
        }

        // Upper left diagonal check
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Lower left diagonal check
        for (int i = r, j = c; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    private void solve(char[][] board, List<List<String>> ans, int n, int col) {
        if (col == n) {
            List<String> solution = new ArrayList<>();
            for (char[] row : board) {
                solution.add(new String(row));
            }
            ans.add(solution);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                solve(board, ans, n, col + 1);
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n)
    {
        char[][] board = new char[n][n];
        for(char[] r : board) Arrays.fill(r,'.');
        List<List<String>> ans = new ArrayList<>();
        solve(board, ans, n, 0);
        return ans;
    }
}