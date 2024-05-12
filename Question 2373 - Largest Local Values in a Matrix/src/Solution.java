class Solution
{
    private int solve(int[][] grid, int r, int c)
    {
        int maxi = Integer.MIN_VALUE;
        for(int i = r; i < r + 3; i++)
        {
            for(int j = c; j < c + 3; j++)
            {
                maxi = Math.max(maxi, grid[i][j]);
            }
        }

        return maxi;
    }

    public int[][] largestLocal(int[][] grid)
    {
        int n = grid.length, m = grid[0].length;
        int[][] ans = new int[n-2][m-2];

        for(int i = 0; i < n-2; i++)
        {
            for(int j = 0; j < m-2; j++)
            {
                ans[i][j] = solve(grid, i, j);
            }
        }

        return ans;
    }
}