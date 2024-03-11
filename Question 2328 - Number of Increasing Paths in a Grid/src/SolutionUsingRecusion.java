class SolutionUsingRecusion
{
    private int dfs(int[][] grid, boolean[][] visited, int r, int c, int[][] dir)
    {
        visited[r][c] = true;
        int len = 1;

        for(int[] d : dir)
        {
            int x = r + d[0];
            int y = c + d[1];

            if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && !visited[x][y] && grid[x][y] > grid[r][c])
            {
                len += dfs(grid, visited, x, y, dir);
            }
        }

        visited[r][c] = false;
        return len;
    }
    public int countPaths(int[][] grid)
    {
        int row = grid.length;
        int col = grid[0].length;

        int ans = 0;
        boolean[][] visited = new boolean[row][col];
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans += dfs(grid,visited,i,j, dir);
                ans %= 1000000007;
            }
        }

        return ans;
    }
}