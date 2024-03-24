import java.util.*;

class Solution
{
    private static class pair
    {
        long first;
        int second;

        public pair(long first, int second)
        {
            this.first = first;
            this.second = second;
        }
    }
    public long[] mostFrequentIDs(int[] nums, int[] freq)
    {
        List<Long> ans = new ArrayList<>();
        PriorityQueue<pair> pq = new PriorityQueue<>(new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                return Long.compare(o2.first,o1.first);
            }
        });

        Map<Integer,Long> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i],0L)+freq[i]);
            pq.add(new pair(map.get(nums[i]),nums[i]));

            while (true)
            {
                pair temp = pq.peek();
                if(temp.first == map.get(temp.second))
                {
                    ans.add(temp.first);
                    break;
                }
                else pq.poll();
            }
        }

        long[] res = new long[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }
}