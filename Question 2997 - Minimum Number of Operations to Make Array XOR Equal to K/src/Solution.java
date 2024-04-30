class Solution
{
    public int minOperations(int[] nums, int k)
    {
        int ans = 0;
        for(int n : nums) ans ^= n;

        ans ^= k; //ans needs to be 0

        int count = 0;
        while(ans > 0)
        {
            if((ans & 1) != 0) count++;
            ans = ans >> 1;
        }

        return count;
    }
}