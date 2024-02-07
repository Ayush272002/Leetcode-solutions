import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public String frequencySort(String s)
    {
        HashMap<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b)->Integer.compare(b.second, a.second));

        StringBuilder sb = new StringBuilder();

        for(Map.Entry<Character,Integer> mp: map.entrySet())
        {
            maxHeap.add(new Pair(mp.getKey(), mp.getValue()));
        }

        while(!maxHeap.isEmpty())
        {
            Pair temp = maxHeap.poll();

            for (int i = 0; i < temp.second; i++) {
                sb.append(temp.first);
            }
        }

        return sb.toString();
    }
}