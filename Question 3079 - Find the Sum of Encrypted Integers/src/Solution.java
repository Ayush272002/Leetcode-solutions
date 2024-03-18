class Solution
{
    private int encrypt(int n)
    {
        int digits = String.valueOf(n).length();
        int maxDigit = 0;
        while (n != 0)
        {
            int digit = n%10;
            maxDigit = Math.max(maxDigit,digit);
            n /= 10;
        }

        int ans = 0;
        for (int i = 0; i < digits; i++) {
            ans *= 10;
            ans += maxDigit;
        }

        return ans;
    }
    public int sumOfEncryptedInt(int[] nums)
    {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += encrypt(nums[i]);
        }

        return ans;
    }
}