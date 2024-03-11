import java.util.Arrays;

class TopDownApproach
{
    private int dfs(int[][] grid, boolean[][] visited, int[][] dir, int r, int c, int[][] dp)
    {
        if(dp[r][c] != -1) return dp[r][c];
        visited[r][c] = true;
        int len = 1;

        for(int[] d : dir)
        {
            int x = r + d[0];
            int y = c + d[1];

            if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && !visited[x][y] && grid[x][y] > grid[r][c])
            {
                len += dfs(grid, visited, dir, x, y, dp);
                len %= 1000000007;
            }
        }

        visited[r][c] = false;
        dp[r][c] = len;
        return dp[r][c];
    }
    public int countPaths(int[][] grid)
    {
        int row = grid.length;
        int col = grid[0].length;

        int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
        boolean[][] visited = new boolean[row][col];

        int ans = 0;
        int[][] dp = new int[row][col];
        Arrays.stream(dp).forEach(r->Arrays.fill(r,-1));


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans += dfs(grid,visited,dir,i,j,dp);
                ans %= 1000000007;
            }
        }

        return ans;
    }
}