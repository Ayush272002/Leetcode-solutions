class Solution {
    private void dfs(char[][] board, boolean[][] visited, int[][] dir, int r, int c) {
        visited[r][c] = true;

        for (int[] d : dir) {
            int x = r + d[0];
            int y = c + d[1];

            if (x >= 0 && y >= 0 && x < board.length && y < board[0].length && !visited[x][y] && board[x][y] == 'O') {
                dfs(board, visited, dir, x, y);
            }
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];
        int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        for (int col = 0; col < m; col++) {
            if (!visited[0][col] && board[0][col] == 'O')
                dfs(board, visited, dir, 0, col);

            if (!visited[n - 1][col] && board[n - 1][col] == 'O')
                dfs(board, visited, dir, n - 1, col);
        }

        for (int row = 0; row < n; row++) {
            if (!visited[row][0] && board[row][0] == 'O')
                dfs(board, visited, dir, row, 0);

            if (!visited[row][m - 1] && board[row][m - 1] == 'O')
                dfs(board, visited, dir, row, m - 1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }

    }
}