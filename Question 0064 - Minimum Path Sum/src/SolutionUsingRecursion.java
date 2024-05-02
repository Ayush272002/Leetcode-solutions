class SolutionUsingRecursion
{
    private int solve(int[][] grid, int r, int c)
    {
        //base case
        if(r == grid.length - 1 && c == grid[0].length-1) return grid[r][c];
        if(r == grid.length -1) return grid[r][c] + solve(grid, r, c+1);
        if(c == grid[0].length -1) return grid[r][c] + solve(grid, r+1, c);

        int mini;
        //right
        mini = grid[r][c] + solve(grid, r, c+1);

        //down
        mini = Math.min(mini, grid[r][c] + solve(grid, r+1, c));

        return mini;
    }

    public int minPathSum(int[][] grid)
    {
        return solve(grid, 0, 0);
    }
}