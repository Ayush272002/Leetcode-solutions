class Solution
{
    public int numberOfSpecialChars(String word)
    {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];

        int count = 0;
        for(char ch : word.toCharArray())
        {
            if(Character.isLowerCase(ch)) lower[ch-'a'] = !upper[ch-'a'];
            else upper[ch-'A'] = true;
        }

        for(int i = 0; i < 26; i++)
        {
            count += lower[i] && upper[i] ? 1 : 0;
        }

        return count;
    }
}