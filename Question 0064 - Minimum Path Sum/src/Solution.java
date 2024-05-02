import java.util.Arrays;

class Solution
{
    private int solve(int[][] grid, int r, int c, int[][] dp)
    {
        //base case
        if(r == grid.length - 1 && c == grid[0].length-1) return grid[r][c];
        if(r == grid.length -1) return grid[r][c] + solve(grid, r, c+1, dp);
        if(c == grid[0].length -1) return grid[r][c] + solve(grid, r+1, c, dp);
        if(dp[r][c] != -1) return dp[r][c];

        int mini;
        //right
        mini = grid[r][c] + solve(grid, r, c+1, dp);

        //down
        mini = Math.min(mini, grid[r][c] + solve(grid, r+1, c, dp));

        return dp[r][c] = mini;
    }

    public int minPathSum(int[][] grid)
    {
        int[][] dp = new int[grid.length][grid[0].length];
        Arrays.stream(dp).forEach(r->Arrays.fill(r,-1));
        return solve(grid, 0, 0, dp);
    }
}