class Solution
{
    private boolean check(String s, int start, int end)
    {
        while(start <= end)
        {
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }
    public boolean validPalindrome(String s)
    {
        int start = 0, end = s.length() - 1;
        int count = 1;
        while(start <= end)
        {
            if(s.charAt(start) != s.charAt(end))
            {
                if(count==1)
                {
                    return check(s,start+1,end) || check(s,start,end-1);
                }
                else return false;
            }

            start++;
            end--;
        }

        return true;
    }
}