class Solution
{
    private int solve(int[][] grid, boolean[][] visited, int r, int c, int[][] dir, int gold)
    {
        visited[r][c] = true;
        int maxGold = gold;

        for(int[] d : dir)
        {
            int newX = r + d[0];
            int newY = c + d[1];

            if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && !visited[newX][newY] && grid[newX][newY] != 0)
            {
                maxGold = Math.max(maxGold, grid[newX][newY] + solve(grid, visited, newX, newY, dir, gold));
            }
        }

        visited[r][c] = false;
        return maxGold;
    }
    public int getMaximumGold(int[][] grid)
    {
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];

        int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
        int currGold = 0;
        int maxGold = Integer.MIN_VALUE;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid[i][j] != 0)
                {
                    currGold = solve(grid,visited,i,j,dir,grid[i][j]);
                }
                maxGold = Math.max(currGold,maxGold);
            }
        }
        return maxGold;
    }
}