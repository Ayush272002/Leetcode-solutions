class Solution {
    private int solve(int[][] obstacleGrid, int r, int c) {
        // base case: reached the destination
        if (r == 0 && c == 0) return 1;

        // base case: out of bounds or obstacle encountered
        if (r < 0 || c < 0 || obstacleGrid[r][c] == 1) return 0;

        int[][] dp = new int[r+1][c+1];

        for(int j = 0; j<= c; j++)
        {
            if(obstacleGrid[0][j] == 0) dp[0][j] = 1;
            else break;
        }

        for (int i = 0; i <= r; i++)
        {
            if(obstacleGrid[i][0] == 0) dp[i][0] = 1;
            else break;
        }

        for (int i = 1; i <= r ; i++) {
            for (int j = 1; j <= c ; j++) {
                if(obstacleGrid[i][j]==0) dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        return dp[r][c];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        // check if the starting point or destination has an obstacle
        if (obstacleGrid[0][0] == 1 || obstacleGrid[rows - 1][cols - 1] == 1) {
            return 0;
        }

        return solve(obstacleGrid, rows - 1, cols - 1);
    }
}
