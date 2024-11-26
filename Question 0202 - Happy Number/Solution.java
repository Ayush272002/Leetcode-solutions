class Solution {
    public boolean isHappy(int n) {
        if (n >= 0 && n <= 9) {
            if (n == 1 || n == 7)
                return true;
            else
                return false;
        }

        int sqSum = 0;

        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            sqSum += (digit * digit);
        }

        return isHappy(sqSum);
    }
}