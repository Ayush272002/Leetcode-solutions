import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs)
    {
        HashMap<String,List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] letters = strs[i].toCharArray();
            Arrays.sort(letters);

            String sortedWords = new String(letters);

            if(!map.containsKey(sortedWords)) map.put(sortedWords, new ArrayList<>());
            map.get(sortedWords).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

}