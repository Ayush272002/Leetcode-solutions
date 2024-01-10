class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }

        char[] c = sb.toString().toCharArray();
        int start = 0;
        int end = c.length - 1;

        while (start < end) {
            if (c[start] == c[end]) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
