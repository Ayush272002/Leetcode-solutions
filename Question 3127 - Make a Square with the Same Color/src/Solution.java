class Solution
{
    public boolean canMakeSquare(char[][] grid)
    {
        for(int i = 0; i < 2; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                int w = (grid[i][j] == 'W' ? 1 : 0) + (grid[i][j+1] == 'W' ? 1 : 0) + (grid[i+1][j] == 'W' ? 1 : 0) + (grid[i+1][j+1] == 'W' ? 1 : 0);
                int b = (grid[i][j] == 'B' ? 1 : 0) + (grid[i][j+1] == 'B' ? 1 : 0) + (grid[i+1][j] == 'B' ? 1 : 0) + (grid[i+1][j+1] == 'B' ? 1 : 0);
                if(Math.max(w, b) >= 3) return true;
            }
        }

        return false;
    }
}