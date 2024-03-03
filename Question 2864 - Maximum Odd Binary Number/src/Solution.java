class Solution {
    public String maximumOddBinaryNumber(String s)
    {
        int n = s.length();

        int one = 0;

        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '1') one++;

        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < one-1; i++) {
            ans.append('1');
        }

        int zeros = n-one;
        for (int i = 0; i < zeros; i++) {
            ans.append('0');
        }

        ans.append('1');
        return ans.toString();
    }
}