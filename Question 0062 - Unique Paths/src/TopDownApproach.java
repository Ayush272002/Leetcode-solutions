import java.util.Arrays;

class TopDownApproach
{
    private int solve(int r, int c, int[][] dp)
    {
        //base case
        if(r == 1 || c == 1) return 1;
        if(dp[r][c] != -1) return dp[r][c];


        int down = solve(r-1, c, dp);
        int left = solve(r, c-1, dp);

        dp[r][c] = down+left;
        return down+left;
    }
    public int uniquePaths(int m, int n)
    {
        int[][] dp = new int[m+1][n+1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return solve(m,n, dp);
    }
}