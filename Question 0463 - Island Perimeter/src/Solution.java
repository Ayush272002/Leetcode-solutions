class Solution
{
    public int islandPerimeter(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dir = {{-1,0}, {1,0}, {0,1}, {0,-1}};
        int ans = 0;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == 1)
                {
                    for(int[] d : dir)
                    {
                        int x = i + d[0];
                        int y = j + d[1];

                        if(x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0) ans++;
                    }
                }
            }
        }

        return ans;
    }
}