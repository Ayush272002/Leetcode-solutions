class Solution2
{
    public int lengthOfLastWord(String s) 
    {
        s = s.trim();
        String[] arr = s.split("\\s+");
        return arr[arr.length-1].length();
    }
}