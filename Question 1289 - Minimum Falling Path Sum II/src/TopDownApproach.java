import java.util.Arrays;

class TopDownApproach
{
    private int solve(int[][] grid, int row, int prevCol, int[][] dp)
    {
        if(row >= grid.length) return 0;
        if(dp[row][prevCol] != -1) return dp[row][prevCol];

        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < grid[0].length; j++)
        {
            if(j == prevCol) continue;
            ans = Math.min(ans, grid[row][j] + solve(grid, row + 1, j, dp));
        }

        return dp[row][prevCol] = ans;
    }

    public int minFallingPathSum(int[][] grid)
    {
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[grid.length][grid[0].length];
        Arrays.stream(dp).forEach(r->Arrays.fill(r,-1));

        for(int i = 0; i < grid.length; i++)
        {
            ans  = Math.min(ans, grid[0][i] + solve(grid, 1, i, dp));
        }
        return ans;
    }
}