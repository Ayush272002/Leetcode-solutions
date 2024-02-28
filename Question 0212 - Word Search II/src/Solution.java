import java.util.ArrayList;
import java.util.List;

class Solution
{
    private void dfs(char[][] board, int r, int c, TrieNode node, ArrayList<String> ans, StringBuilder word, int[][] dir, boolean[][] visited)
    {
        if (r < 0 || c < 0 || r >= board.length || c >= board[r].length || visited[r][c]) return;

        if (node.children[board[r][c]- 'a'] == null) return;

        char ch = board[r][c];
        visited[r][c] = true;
        word.append(ch);

        node = node.children[ch-'a'];
        if (node.isTerminal)
        {
            ans.add(word.toString());
            node.isTerminal = false;
        }

        for(int[] d : dir)
        {
            int newX = r + d[0];
            int newY = c + d[1];
            dfs(board, newX, newY, node, ans, word, dir, visited);
        }

        word.deleteCharAt(word.length()-1);
        visited[r][c] = false;

    }
    public List<String> findWords(char[][] board, String[] words)
    {
        Trie t = new Trie();
        for (String word : words)
        {
            t.insertWord(word);
        }

        ArrayList<String> ans = new ArrayList<>();
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                StringBuilder word = new StringBuilder();
                dfs(board, i, j, t.root , ans, word, dir, visited);
            }
        }

        return ans;
    }
}