import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split("\\s+");

        if (pattern.length() != words.length)
            return false;

        Map<Character, String> map = new HashMap<>();
        Map<String, Character> revMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (map.containsKey(c)) {
                if (!map.get(c).equals(word))
                    return false;
            } else {
                if (revMap.containsKey(word) && revMap.get(word) != c)
                    return false;

                map.put(c, word);
                revMap.putIfAbsent(word, c);
            }
        }

        return true;
    }
}