import java.util.Arrays;

class TopDownDP
{
    private int solve(String s, int k, int i, int lastChar, int[][] dp)
    {
        if(i >= s.length()) return 0;
        if(dp[i][lastChar+1] != -1) return dp[i][lastChar+1];

        int take = 0, skip = 0;
        //take
        if(lastChar == -1 || Math.abs(lastChar - (s.charAt(i) - 'a')) <= k)
        {
            take = 1 + solve(s, k, i+1, s.charAt(i)-'a', dp);
        }

        //skip
        skip = solve(s, k, i+1, lastChar, dp);

        return dp[i][lastChar+1] = Math.max(take, skip);
    }
    public int longestIdealString(String s, int k)
    {
        int[][] dp = new int[s.length()][27];
        Arrays.stream(dp).forEach(r->Arrays.fill(r,-1));
        return solve(s, k, 0, -1, dp);
    }
}