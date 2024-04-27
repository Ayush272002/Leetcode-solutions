class OptimalSol
{
    public int minFallingPathSum(int[][] grid)
    {
        int n = grid.length;
        for (int row = 1; row < n; row++)
        {
            for (int col = 0; col < n; col++)
            {
                int min = Integer.MAX_VALUE;

                for (int i = 0; i < n; ++i)
                {
                    if (i == col) continue;;
                    min = Math.min(min, grid[row - 1][i]);
                }

                grid[row][col] += min;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int num : grid[n - 1]) {
            ans = Math.min(ans, num);
        }

        return ans;
    }
}
