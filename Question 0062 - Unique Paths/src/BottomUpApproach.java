public class BottomUpApproach
{
    private int solve(int r, int c)
    {
        //dp arrays
        int[][] dp = new int[r+1][c+1];
        for (int i = 0; i < r; i++)
            dp[i][0] = 1;
        for (int j = 0; j < c; j++)
            dp[0][j] = 1;

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[r-1][c-1];
    }
    public int uniquePaths(int m, int n)
    {
        return solve(m,n);
    }
}
