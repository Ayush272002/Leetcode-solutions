class Solution
{
    public int minimumLength(String s)
    {
        int start = 0, end = s.length()-1;

        while(start < end && s.charAt(start) == s.charAt(end))
        {
            char curr = s.charAt(start);
            while(start < s.length() && s.charAt(start) == curr)
                start++;

            while(end >= 0 && s.charAt(end) == curr)
                end--;
        }

        return (end < start) ? 0 : end-start+1;
    }
}