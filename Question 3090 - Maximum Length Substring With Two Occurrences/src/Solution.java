class Solution {
    public int maximumLengthSubstring(String s)
    {
        int n = s.length(), maxLen = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++)
        {
            int[] freq = new int[26];
            for(int j = i; j < n; j++)
            {
                freq[s.charAt(j)-'a']++;
                if(freq[s.charAt(j)-'a'] == 3) break;
                maxLen = Math.max(maxLen, j-i+1);
            }
        }

        return maxLen;
    }
}