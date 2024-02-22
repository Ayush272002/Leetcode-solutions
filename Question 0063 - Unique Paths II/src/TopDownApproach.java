import java.util.Arrays;

class TopDownApproach {
    private int solve(int[][] obstacleGrid, int r, int c, int[][] dp) {
        // base case: reached the destination
        if (r == 0 && c == 0) return 1;

        // base case: out of bounds or obstacle encountered
        if (r < 0 || c < 0 || obstacleGrid[r][c] == 1) return 0;

        if(dp[r][c] != -1) return dp[r][c];

        // calculate paths from the left and paths from above
        int left = solve(obstacleGrid, r, c - 1, dp);
        int up = solve(obstacleGrid, r - 1, c, dp);

        dp[r][c] = left+up;
        return left + up;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        // check if the starting point or destination has an obstacle
        if (obstacleGrid[0][0] == 1 || obstacleGrid[rows - 1][cols - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[rows][cols];
        Arrays.stream(dp).forEach(r->Arrays.fill(r,-1));

        return solve(obstacleGrid, rows - 1, cols - 1, dp);
    }
}
