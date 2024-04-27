class SolutionUsingRecursion
{
    private int solve(String ring, String key, int ringPos, int keyPos)
    {
        if(keyPos >= key.length()) return 0;

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
        int clockAns = clockwiseCount + 1 + solve(ring, key, clockwisePos, keyPos + 1);


        //anticlockwise
        int anticlockwiseCount = 0;
        pos = ringPos;
        while(ring.charAt(pos) != c)
        {
            pos = (pos - 1 + ring.length()) % ring.length();
            anticlockwiseCount++;
        }
        int anticlockwisePos = (ringPos - anticlockwiseCount + ring.length()) % ring.length();
        int antiAns = anticlockwiseCount + 1 + solve(ring, key, anticlockwisePos, keyPos + 1);

        //ans
        return Math.min(clockAns, antiAns);
    }
    public int findRotateSteps(String ring, String key)
    {
        return solve(ring, key, 0, 0);
    }
}