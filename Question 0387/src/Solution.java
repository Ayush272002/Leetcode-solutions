import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> count = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            //increase count
            count.put(ch , count.getOrDefault(ch ,0) + 1);

            //push in queue
            q.add(ch);

            while(!q.isEmpty())
            {
                if(count.get(q.peek()) > 1)
                {
                    //repeating character popping
                    q.poll();
                }
                else
                {
                    //non-repeating character so push inside
                    ans.append(q.peek());
                    break;
                }
            }

            if(q.isEmpty())
                ans.append('#');
        }
        char ch = ans.charAt(ans.length()-1);
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ch)
                return i;
        }
        return -1;
    }
}