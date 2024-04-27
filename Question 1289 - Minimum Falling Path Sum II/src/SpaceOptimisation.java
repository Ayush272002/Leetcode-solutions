class SpaceOptimisation
{
    public int minFallingPathSum(int[][] grid)
    {
        int ans = Integer.MAX_VALUE;
        int r = grid.length, c = grid[0].length;
        int[] next = new int[c];
        int[] curr = new int[c];
        // Copy the values of the bottom row of the grid to the dp array
        for(int i = 0; i < c; i++) next[i] = grid[c-1][i];

        for(int i = r-2; i >= 0; i--)
        {
            for(int j = 0; j < c; j++)
            {
                int min = Integer.MAX_VALUE;
                for(int k = 0; k < c; k++)
                {
                    if(k == j) continue;
                    min = Math.min(min, grid[i][j] + next[k]);
                }

                curr[j] = min;
            }

            System.arraycopy(curr, 0, next, 0, c);
        }

        for(int i = 0; i < c; i++) ans = Math.min(ans, next[i]);

        return ans;
    }
}