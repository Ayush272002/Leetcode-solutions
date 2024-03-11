import java.util.HashMap;
import java.util.Map;

class Solution {
    public String customSortString(String order, String s)
    {
        Map<Character,Integer> mp = new HashMap<>();
        for(char ch : s.toCharArray()) mp.put(ch,mp.getOrDefault(ch,0)+1);

        StringBuilder ans = new StringBuilder();
        for(char ch : order.toCharArray())
        {
            if(mp.containsKey(ch))
            {
                while(mp.get(ch) != 0)
                {
                    ans.append(ch);
                    mp.put(ch,mp.get(ch)-1);
                }
            }
        }

        for(Map.Entry<Character, Integer> entry : mp.entrySet())
        {
            int count = entry.getValue();
            while(count != 0)
            {
                ans.append(entry.getKey());
                count--;
            }
        }
        return ans.toString();
    }
}