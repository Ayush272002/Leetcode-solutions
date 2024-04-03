class Solution2
{
    private boolean dfs(char[][] board, String word, int r, int c, int[][] dir)
    {
        if(word.isEmpty()) return true;

        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(0))
            return false;
        char ch = board[r][c];
        board[r][c] = '#';

        for(int[] d : dir)
        {
            int x = r + d[0];
            int y = c + d[1];

            if(dfs(board, word.substring(1), x, y, dir)) return true;

        }

        board[r][c] = ch;
        return false;
    }
    public boolean exist(char[][] board, String word)
    {
        int n = board.length;
        int m = board[0].length;

        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if(dfs(board,word,i,j,dir)) return true;
            }
        }

        return false;
    }
}