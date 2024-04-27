class BottomUpApproach
{
    public int minFallingPathSum(int[][] grid)
    {
        int ans = Integer.MAX_VALUE;
        int r = grid.length, c = grid[0].length;
        int[][] dp = new int[r][c];

        // Copy the values of the bottom row of the grid to the dp array
        for(int i = 0; i < c; i++) dp[c-1][i] = grid[c-1][i];

        for(int i = r-2; i >= 0; i--)
        {
            for(int j = 0; j < c; j++)
            {
                int min = Integer.MAX_VALUE;
                for(int k = 0; k < c; k++)
                {
                    if(k == j) continue;
                    min = Math.min(min, grid[i][j] + dp[i+1][k]);
                }

                dp[i][j] = min;
            }
        }

        for(int i = 0; i < c; i++) ans = Math.min(ans, dp[0][i]);

        return ans;
    }
}