class Solution2
{
    private void dfs(char[][] grid, boolean[][] visited, int r, int c, int[][] dir)
    {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || visited[r][c] || grid[r][c] == '0') return;

        visited[r][c] = true;

        for(int[] d : dir)
        {
            int x = r + d[0];
            int y = c + d[1];
            dfs(grid, visited, x, y, dir);
        }

    }
    public int numIslands(char[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(!visited[i][j] && grid[i][j] == '1')
                {
                    dfs(grid, visited, i, j, dir);
                    count++;
                }
            }
        }

        return count;
    }
}