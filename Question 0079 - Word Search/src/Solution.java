class Solution {
    private boolean dfs(String word, char[][] board, int r, int c)
    {
        if(word.isEmpty()) return true;

        if(r<0 || c<0 || r>= board.length || c>=board[0].length || board[r][c] != word.charAt(0)) return false;


        char temp = board[r][c];
        board[r][c] = '#';
        boolean up = dfs(word.substring(1), board, r+1, c);
        boolean down = dfs(word.substring(1), board, r-1, c);
        boolean right = dfs(word.substring(1), board, r, c+1);
        boolean left = dfs(word.substring(1), board, r, c-1);
        board[r][c] = temp;
        return up || down || right||left;

    }
    public boolean exist(char[][] board, String word)
    {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(word,board,i,j)) return true;
            }
        }

        return false;
    }
}