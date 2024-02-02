class Solution {
    public int reverse(int x) {
        int rev=0, rem;
        boolean isneg=false;
        if(x < Integer.MIN_VALUE || x >Integer.MAX_VALUE)
            return 0;
        if(x<0)
        {
            isneg = true;
            x = -1*x;
        }

        while(x>0)
        {
            rem = x%10;
            x = x/10;
            rev = (rev*10)+ rem;

            if(rev%10 != rem)
                return 0;
        }
        if(isneg)
            return -1*rev;
        return rev;
    }

    public boolean isPalindrome(int x)
    {
        if(x<0) return false;
        int rev = reverse(x);

        return x - rev == 0;
    }
}