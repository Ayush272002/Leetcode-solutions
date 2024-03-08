class RecursiveSol
{
    private int solve(int n)
    {
        //base case
        if(n < 0) return 0;
        if(n == 0 || n == 1) return 1;

        int one = solve(n-1);
        int two = solve(n-2);

        return one + two;
    }

    public int climbStairs(int n)
    {
        return solve(n);
    }
}