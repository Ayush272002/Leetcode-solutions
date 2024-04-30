class Solution
{
    public long wonderfulSubstrings(String word)
    {
        int[] count = new int[1024]; //2^10  (a to j)
        int mask = 0;
        long ans = 0;
        count[0] = 1;

        for(char ch : word.toCharArray())
        {
            mask ^= 1 << (ch - 'a'); // a will be 001, b will be 010 etc etc
            ans += count[mask]; //counting even

            for(int i = 0; i < 10; i++) ans += count[mask ^ (1<<i)];
            count[mask]++; //counting odd
        }

        return ans;
    }
}