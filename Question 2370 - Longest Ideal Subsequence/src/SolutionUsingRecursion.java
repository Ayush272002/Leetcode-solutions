class SolutionUsingRecursion
{
    private int solve(String s, int k, int i, char lastChar)
    {
        if(i >= s.length()) return 0;

        int take = 0, skip = 0;
        //take
        if(i == 0 || lastChar == '\0' || Math.abs(lastChar - s.charAt(i)) <= k)
        {
            take = 1 + solve(s, k, i+1, s.charAt(i));
        }

        //skip
        skip = solve(s, k, i+1, lastChar);

        return Math.max(take, skip);
    }
    public int longestIdealString(String s, int k)
    {
        return solve(s, k, 0, '\0');
    }
}