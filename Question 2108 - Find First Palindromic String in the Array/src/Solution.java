class Solution {
    private boolean isPalindrome(String word)
    {
        int start = 0;
        int end = word.length()-1;

        while(end > start)
        {
            if(word.charAt(start) != word.charAt(end)) return false;
            end--;
            start++;
        }

        return true;
    }
    public String firstPalindrome(String[] words) {
        for(String word : words)
        {
            if(isPalindrome(word))
                return word;
        }
        return "";
    }
}