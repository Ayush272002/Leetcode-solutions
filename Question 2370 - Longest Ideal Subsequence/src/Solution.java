class Solution
{
    public int longestIdealString(String s, int k)
    {
        int n = s.length();
        int[] dp = new int[27];

        for(int i = n-1; i >= 0; i--)
        {
            int idx = s.charAt(i) - 'a';

            int max = Integer.MIN_VALUE;

            int left = Math.max(idx-k, 0);
            int right = Math.min(idx+k, 26);

            for(int j = left; j <= right; j++)
                max = Math.max(max, dp[j]);

            dp[idx] = max+1;
        }

        int max = Integer.MIN_VALUE;

        for(int e : dp) max = Math.max(max, e);
        return max;
    }
}