import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public boolean hasCycleUsingHashMap(ListNode head) {

        if(head==null)  return false;
        Map<ListNode, Boolean> visited = new HashMap<>();
        ListNode temp = head;
        while(temp != null)
        {
            //detect cycle
            if(visited.containsKey(temp) && visited.get(temp)) return true;

            visited.put(temp,true);

            temp = temp.next;
        }
        return false;
    }
}