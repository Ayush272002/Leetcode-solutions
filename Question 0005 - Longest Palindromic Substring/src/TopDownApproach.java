class TopDownApproach
{
    private boolean isPalindrome(String s, int left, int right)
    {
        if(left >= right) return true;
        if(dp[left][right] != null) return dp[left][right];
        if(s.charAt(left) != s.charAt(right)) return false;
        if(right - left <= 2) return dp[left][right] = true;

        return dp[left][right] = isPalindrome(s,left+1,right-1);

    }

    Boolean[][] dp;
    public String longestPalindrome(String s)
    {
        int n = s.length();
        int maxLen = 0;
        String ans = "";

        dp = new Boolean[n][n];
        for (int left = 0; left < n; left++)
        {
            for (int right = left; right < n; right++)
            {
                if(s.charAt(left) == s.charAt(right) && isPalindrome(s,left+1,right-1))
                {
                    if(maxLen < right - left + 1)
                    {
                        maxLen = right-left+1;
                        ans = s.substring(left,right+1);
                    }
                }
            }
        }

        return ans;
    }
}