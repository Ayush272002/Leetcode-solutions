class Solution {
    private int solve(int[][] grid, int x, int y, int[][] dir, int emptyCount)
    {
        if(grid[x][y] == 2) return emptyCount == 0 ? 1 : 0;
        if(grid[x][y] == -1) return 0;

        int count = 0;
        grid[x][y] = -1; // mark as visited
        for(int[] d : dir)
        {
            int newX = x + d[0];
            int newY = y + d[1];

            if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] != -1)
                count = count + solve(grid, newX, newY, dir, emptyCount-1);
        }

        grid[x][y] = 0;
        return count;
    }
    public int uniquePathsIII(int[][] grid)
    {
        int startX = -1, startY = -1;
        int emptyCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1)
                {
                    startX = i;
                    startY = j;
                }
                else if(grid[i][j] == 0) emptyCount++;
            }
        }

        int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
        int count = solve(grid,startX, startY, dir, emptyCount+1);
        return count;
    }
}