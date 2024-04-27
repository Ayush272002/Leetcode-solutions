import java.util.Arrays;

class Solution
{
    private int solve(String ring, String key, int ringPos, int keyPos, int[][] dp)
    {
        if(keyPos >= key.length()) return 0;
        if(dp[ringPos][keyPos] != -1) return dp[ringPos][keyPos];

        char c = key.charAt(keyPos);

        //clockwise
        int clockwiseCount = 0;
        int pos = ringPos;
        while(ring.charAt(pos) != c)
        {
            pos = (pos + 1) % ring.length(); //overflow
            clockwiseCount++;
        }
        int clockwisePos = (ringPos + clockwiseCount) % ring.length();
        int clockAns = clockwiseCount + 1 + solve(ring, key, clockwisePos, keyPos + 1, dp);


        //anticlockwise
        int anticlockwiseCount = 0;
        pos = ringPos;
        while(ring.charAt(pos) != c)
        {
            pos = (pos - 1 + ring.length()) % ring.length();
            anticlockwiseCount++;
        }
        int anticlockwisePos = (ringPos - anticlockwiseCount + ring.length()) % ring.length();
        int antiAns = anticlockwiseCount + 1 + solve(ring, key, anticlockwisePos, keyPos + 1, dp);

        return dp[ringPos][keyPos] = Math.min(clockAns, antiAns);
    }
    public int findRotateSteps(String ring, String key)
    {
        int[][] dp = new int[ring.length()][key.length()];
        Arrays.stream(dp).forEach(r->Arrays.fill(r,-1));
        return solve(ring, key, 0, 0, dp);
    }
}