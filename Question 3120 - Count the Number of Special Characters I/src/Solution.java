class Solution
{
    public int numberOfSpecialChars(String word)
    {
        int[] freq = new int[52];
        int count = 0;

        for(char ch : word.toCharArray())
        {
            int i;
            if(ch >= 'a' && ch <= 'z') i = ch-'a';
            else i = ch-'A' + 26;

            freq[i]++;
        }

        for(int i = 0; i < 26; i++)
        {
            if(freq[i] == 0 || freq[i+26] == 0) continue;
            count++;
        }

        return count;
    }
}