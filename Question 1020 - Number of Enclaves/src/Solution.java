class Solution {
    private void dfs(int[][] grid, boolean[][] visited, int r, int c, int[][] dir)
    {
        visited[r][c] = true;

        for(int[] d : dir)
        {
            int x = r+d[0];
            int y = c+d[1];

            if(x > 0 && x < grid.length && y > 0 && y < grid[0].length && !visited[x][y])
            {
                if(grid[x][y] == 1)
                    dfs(grid,visited,x,y,dir);
            }
        }
    }
    public int numEnclaves(int[][] grid)
    {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
        int ans = 0;

        for (int col = 0; col < grid[0].length; col++) {
            //first row -0 row
            if(!visited[0][col] && grid[0][col] == 1)
                dfs(grid,visited,0,col,dir);

            //last row
            if(!visited[grid.length-1][col] && grid[grid.length-1][col] == 1)
                dfs(grid,visited,grid.length-1,col,dir);

        }

        for (int row = 0; row < grid.length; row++) {
            //first col
            if(!visited[row][0] && grid[row][0] == 1)
                dfs(grid,visited,row,0,dir);

            //last col
            if(!visited[row][grid[0].length-1] && grid[row][grid[0].length-1] == 1)
                dfs(grid,visited,row,grid[0].length-1,dir);
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(!visited[i][j] && grid[i][j] == 1) ans++;
            }
        }

        return ans;
    }
}