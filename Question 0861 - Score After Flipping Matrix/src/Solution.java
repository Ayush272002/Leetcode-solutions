class Solution
{
    private void flipRow(int[][] grid, int row)
    {
        for(int col = 0; col < grid[0].length; col++)
        {
            grid[row][col] = (grid[row][col] == 1) ? 0 : 1;
        }
    }

    private int countOnes(int[][] grid, int col)
    {
        int count = 0;
        for(int row = 0; row < grid.length; row++)
        {
            if(grid[row][col] == 1) count++;
        }

        return count;
    }

    public int matrixScore(int[][] grid)
    {
        for(int row = 0; row < grid.length; row++)
        {
            if(grid[row][0] == 0) flipRow(grid, row);
        }

        int power = grid[0].length-1;
        int score = (int) (grid.length * Math.pow(2, power));
        power--;

        //score of each col
        for(int col = 1; col < grid[0].length; col++)
        {
            int count1 = countOnes(grid, col);
            int count0 = grid.length - count1;

            score += (int)(Math.max(count0, count1) * Math.pow(2, power));
            power--;
        }

        return score;
    }
}