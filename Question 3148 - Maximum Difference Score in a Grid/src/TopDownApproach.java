import java.util.Arrays;
import java.util.List;

class TopDownApproach
{
    private int solve(List<List<Integer>> grid, int r, int c, int[][] dp)
    {
        //base case
        if(r >= grid.size() || c >= grid.getFirst().size()) return Integer.MIN_VALUE;
        if(dp[r][c] != -1) return dp[r][c];

        int ans = (int) -(1e6);
        int val = grid.get(r).get(c);

        int temp = Math.max(0, solve(grid, r+1, c, dp));
        //right
        if(r + 1 < grid.size())
        {
            ans = Math.max(ans, grid.get(r+1).get(c) - val + temp);
        }

        temp = Math.max(0, solve(grid, r, c+1, dp));
        //down
        if(c + 1 < grid.get(0).size())
        {
            ans = Math.max(ans, grid.get(r).get(c+1) - val + temp);
        }

        return dp[r][c] = ans;
    }

    public int maxScore(List<List<Integer>> grid)
    {
        int r = grid.size(), c = grid.get(0).size();
        int ans = Integer.MIN_VALUE;
        int[][] dp = new int[r][c];
        Arrays.stream(dp).forEach(row->Arrays.fill(row,-1));

        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                ans = Math.max(ans, solve(grid, i, j, dp));
            }
        }

        return ans;
    }
}