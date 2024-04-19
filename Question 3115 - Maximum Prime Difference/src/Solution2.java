class Solution2
{
    public int maximumPrimeDifference(int[] nums)
    {
        int i=0, j=nums.length - 1;

        while(i < j) {
            if(isPrime(nums[i]) && isPrime(nums[j])) {
                return j-i;
            }
            else if(isPrime(nums[i]) && !isPrime(nums[j])) {
                j--;
            } else if(!isPrime(nums[i]) && isPrime(nums[j])) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return 0;
    }

    private boolean isPrime(int n)
    {
        if(n == 1) return false;
        if(n == 2) return true;
        if(n % 2 == 0) return false; // eliminates 50% of cases
        for(int i=3; i <= (int)Math.sqrt(n); i++)
        {
            if(n % i == 0) return false;
        }
        return true;
    }
}