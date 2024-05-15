import java.util.List;

class Solution
{
    private int solve(List<List<Integer>> grid, int r, int c)
    {
        //base case
        if(r >= grid.size() || c >= grid.getFirst().size()) return Integer.MIN_VALUE;

        int ans = (int) -(1e6);
        int val = grid.get(r).get(c);

        int temp = Math.max(0, solve(grid, r+1, c));
        //right
        if(r + 1 < grid.size())
        {
            ans = Math.max(ans, grid.get(r+1).get(c) - val + temp);
        }

        temp = Math.max(0, solve(grid, r, c+1));
        //down
        if(c + 1 < grid.get(0).size())
        {
            ans = Math.max(ans, grid.get(r).get(c+1) - val + temp);
        }

        return ans;
    }

    public int maxScore(List<List<Integer>> grid)
    {
        int r = grid.size(), c = grid.get(0).size();
        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                ans = Math.max(ans, solve(grid, i, j));
            }
        }

        return ans;
    }
}