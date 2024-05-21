class OptimisedSol
{
    private int solve(int[][] grid, int r, int c, int[][] dir, int gold)
    {
        //base case
        if(r >= grid.length || r < 0 || c >= grid[0].length || c < 0 || grid[r][c] == 0) return gold;

        int temp = grid[r][c];
        grid[r][c] = 0;
        int maxGold = gold;

        for(int[] d : dir)
        {
            int x = r + d[0];
            int y = c + d[1];

            maxGold = Math.max(maxGold, solve(grid, x, y, dir, gold + temp));
        }

        grid[r][c] = temp;
        return maxGold;
    }

    public int getMaximumGold(int[][] grid)
    {
        int r = grid.length, c = grid[0].length;
        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                if(grid[i][j] != 0)
                {
                    int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
                    ans = Math.max(ans, solve(grid, i, j, dir, 0));
                }
            }
        }

        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}