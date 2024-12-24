import java.util.Arrays;

class Solution {
    private int solve(String s, int idx, int[] dp) {

        if (idx == s.length()) {
            return 1;
        }

        if (s.charAt(idx) == '0')
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        // take 1
        int res = solve(s, idx + 1, dp);

        // take 2
        if (idx + 1 < s.length()) {
            String twoDigit = s.substring(idx, idx + 2);
            int num = Integer.parseInt(twoDigit);
            if (num >= 10 && num <= 26) {
                res += solve(s, idx + 2, dp);
            }
        }

        return dp[idx] = res;
    }

    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.startsWith("0"))
            return 0;

        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return solve(s, 0, dp);
    }
}