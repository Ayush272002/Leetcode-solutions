class Solution {
    private void dfs(char[][] board, boolean[][] visited, int r, int c, int[][] dir)
    {
        visited[r][c] = true;

        for(int[] d: dir)
        {
            int newR = r+d[0];
            int newY = c+d[1];

            if(newR >0 && newR < board.length && newY > 0 && newY <board[0].length && !visited[newR][newY])
            {
                if(board[newR][newY] == 'O')
                    dfs(board,visited,newR, newY, dir);
            }
        }

    }
    public void solve(char[][] board)
    {
        boolean[][] visited = new boolean[board.length][board[0].length];

        int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};

        for (int col = 0; col < board[0].length; col++)
        {
            //first row
            if(!visited[0][col] && board[0][col] == 'O')
                dfs(board,visited,0,col, dir);

            //last row
            if(!visited[board.length-1][col] && board[board.length-1][col] == 'O')
                dfs(board,visited,board.length-1,col,dir);

        }

        for (int row = 0; row < board.length; row++) {
            //first col
            if(!visited[row][0] && board[row][0] == 'O')
                dfs(board,visited,row,0,dir);

            //last col
            if(!visited[row][board[0].length-1] && board[row][board[0].length-1] == 'O')
                dfs(board,visited,row,board[0].length-1,dir);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(!visited[i][j] && board[i][j]=='O') board[i][j] = 'X';
            }
        }
    }
}