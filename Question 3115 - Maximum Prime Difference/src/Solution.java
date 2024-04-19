import java.util.Arrays;

class Solution
{
    private void sieve(boolean[] primes, int n)
    {
        Arrays.fill(primes, true);

        primes[0] = primes[1] = false;
        for(int i = 2; i < n; i++)
        {
            if(primes[i])
            {
                for(int j = 2*i; j < n; j = j+i)
                {
                    primes[j] = false;
                }
            }
        }
    }

    public int maximumPrimeDifference(int[] nums)
    {
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) maxi = Math.max(maxi, nums[i]);

        maxi = maxi + 1;
        boolean[] primes = new boolean[maxi];

        sieve(primes, maxi);

        int start = 0, end = nums.length-1;
        for(int i = 0; i < nums.length; i++)
        {
            if(primes[nums[i]])
            {
                start = i;
                break;
            }
        }


        for(int i = nums.length - 1; i >= 0; i--)
        {
            if(primes[nums[i]])
            {
                end = i;
                break;
            }
        }

        return Math.abs(start-end);
    }
}