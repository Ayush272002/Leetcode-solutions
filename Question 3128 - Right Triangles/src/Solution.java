class Solution
{
    public long numberOfRightTriangles(int[][] grid)
    {
        int[] row1 = new int[grid.length];
        int[] col1 = new int[grid[0].length];
        long count = 0;

        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                {
                    row1[i]++;
                    col1[j]++;
                }
            }
        }

        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1) count += (long) (row1[i] - 1) * (col1[j] - 1);
            }
        }

        return count;
    }
}