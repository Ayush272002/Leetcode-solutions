class Solution
{
    public char findTheDifference(String s, String t)
    {
        int[] map = new int[26];
        for(int i = 0; i < t.length(); i++)
        {
            map[t.charAt(i)-'a']++;

            if(i < s.length()) map[s.charAt(i)-'a']--;
        }

        int idx =0;
        for(int i = 0; i < 26; i++)
        {
            if(map[i] == 1) idx = i;
        }

        return (char) (idx+'a');
    }
}