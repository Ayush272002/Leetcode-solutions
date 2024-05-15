class Solution
{
    public long minEnd(int n, int x)
    {
        int[] xBit = new int[64];
        int[] nBit = new int[64];

        n--;

        for(int i = 0; i < 32; i++)
        {
            xBit[i] = (x>>i) & 1;
            nBit[i] = (n>>i) & 1;
        }

        int i = 0, j = 0; //xBit, nBit
        while(i < 64)
        {
            if(xBit[i] == 1)
            {
                i++;
                continue;
            }

            xBit[i++] = nBit[j++];
        }

        long ans = 0L;
        for(i = 0; i < 64; i++)
        {
            ans += xBit[i] * (1L<<i);
        }

        return ans;
    }
}