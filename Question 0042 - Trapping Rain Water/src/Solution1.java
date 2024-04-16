class Solution1
{
    public int trap(int[] height)
    {
        int n = height.length;
        int[] pf = new int[n];
        int[] sf = new int[n];

        pf[0] = height[0];
        for(int i = 1; i < n; i++)
        {
            pf[i] = Math.max(pf[i-1], height[i]);
        }

        sf[n-1] = height[n-1];
        for(int i = n-2; i >= 0; i--)
        {
            sf[i] = Math.max(sf[i+1], height[i]);
        }

        int ans = 0;
        for(int i = 0; i < n; i++)
        {
            ans += Math.min(sf[i], pf[i]) - height[i];
        }

        return ans;
    }
}

//solution using prefix and suffix sum
//water level at particular is min(max to right, max left) - curr height