class Solution
{
    public long maximumValueSum(int[] nums, int k, int[][] edges)
    {
        long count = 0, sacrifice = Long.MAX_VALUE, sum = 0;

        for(int n : nums)
        {
            if((n^k) > n)
            {
                sum += n^k;
                sacrifice = Math.min(sacrifice, (n^k) - n);
                count++;
            }
            else
            {
                sum += n;
                sacrifice = Math.min(sacrifice, n - (n^k));
            }
        }

        //even no. of elements to be increased so no sacrifice needed as all decreasing will turn to original by another xor
        return count % 2 == 0 ? sum : sum - sacrifice;
    }
}