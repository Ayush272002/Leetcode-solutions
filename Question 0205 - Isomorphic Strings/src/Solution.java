import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> revMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map.containsKey(c1)) {
                if (!map.get(c1).equals(c2))
                    return false;
            } else {
                if (revMap.containsKey(c2) && revMap.get(c2) != c1)
                    return false;

                map.put(c1, c2);
                revMap.put(c2, c1);
            }
        }

        return true;
    }
}