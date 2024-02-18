import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k)
    {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : arr)
            map.put(i,map.getOrDefault(i,0)+1);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(map.values());

        while(!minHeap.isEmpty() && k>0 && minHeap.peek() <= k)
        {
            if(minHeap.peek() <= k)
            {
                k -= minHeap.peek();
                minHeap.remove();
            }
        }

        return minHeap.size();
    }
}