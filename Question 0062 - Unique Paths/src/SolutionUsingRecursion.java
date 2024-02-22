class SolutionUsingRecursion
{
    private int solve(int r, int c)
    {
        //base case
        if(r == 1 || c == 1) return 1;


        int down = solve(r-1, c);
        int left = solve(r, c-1);

        return down+left;
    }
    public int uniquePaths(int m, int n)
    {
        return solve(m,n);
    }
}