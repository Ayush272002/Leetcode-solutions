class SolutionUsingRecursion
{
    private int solve(int[][] grid, int row, int prevCol)
    {
        if(row >= grid.length) return 0;

        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < grid[0].length; j++)
        {
            if(j == prevCol) continue;
            ans = Math.min(ans, grid[row][j] + solve(grid, row + 1, j));
        }

        return ans;
    }

    public int minFallingPathSum(int[][] grid)
    {
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < grid.length; i++)
        {
            ans  = Math.min(ans, grid[0][i] + solve(grid, 1, i));
        }
        return ans;
    }
}