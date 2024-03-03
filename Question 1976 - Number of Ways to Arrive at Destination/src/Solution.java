import java.util.*;

class Solution {
    private static class Pair<T, V>
    {
        T first;
        V second;
        Pair(T first, V second)
        {
            this.first = first;
            this.second = second;
        }
    }

    public int countPaths(int n, int[][] roads)
    {
        long mod = 1000000007L;
        // adj list
        Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();

        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] road : roads)
        {
            int u = road[0];
            int v = road[1];
            int w = road[2];
            adj.get(u).add(new Pair<>(v, w));
            adj.get(v).add(new Pair<>(u, w));
        }

        // dijkstra
        Queue<Pair<Long, Integer>> q = new PriorityQueue<>(Comparator.comparingLong(x -> x.first));
        ArrayList<Long> dist = new ArrayList<>(Collections.nCopies(n, (long) 1e12));
        ArrayList<Long> ways = new ArrayList<>(Collections.nCopies(n, 0L));

        dist.set(0, 0L);
        ways.set(0, 1L);

        q.add(new Pair<>(0L, 0));

        while (!q.isEmpty())
        {
            Pair<Long, Integer> temp = q.poll();
            long dis = temp.first;
            int node = temp.second;

            for (Pair<Integer, Integer> nbr : adj.get(node))
            {
                int adjNode = nbr.first;
                int adjDis = nbr.second;

                // first time coming with short distance
                if (dis + adjDis < dist.get(adjNode))
                {
                    dist.set(adjNode, dis + adjDis);
                    q.add(new Pair<>(dis + adjDis, adjNode));
                    ways.set(adjNode, ways.get(node));
                }
                else if (dis + adjDis == dist.get(adjNode))
                {
                    ways.set(adjNode, (ways.get(adjNode) + ways.get(node)) % mod);
                }
            }
        }

        return (int) (ways.get(n - 1) % mod);
    }
}
