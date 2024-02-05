import java.util.Hashtable;

class Solution2 {
    public int firstUniqChar(String s)
    {
        Hashtable<Character,Integer> table = new Hashtable<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            table.put(ch, table.getOrDefault(ch,0)+1);
        }

        for (int i = 0; i < s.length(); i++) {
            if(table.get(s.charAt(i))==1) return i;
        }
        return -1;
    }
}