import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] a = s.toCharArray();
        Arrays.sort(a);

        char[] b = t.toCharArray();
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }
}