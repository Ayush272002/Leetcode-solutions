import java.util.HashMap;
import java.util.Map;
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null)  return null;
        Map<ListNode, Boolean> visited = new HashMap<>();
        ListNode temp = head;
        while(temp != null)
        {
            //detect cycle
            if(visited.containsKey(temp) && visited.get(temp)) return temp;

            visited.put(temp,true);

            temp = temp.next;
        }
        return null;
    }
}