import java.util.*;

class OptimisedSol
{
    private static class Pair<T, U>
    {
        T first;
        U second;

        Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k)
    {
        //adj list
        Map<Integer, List<Pair<Integer,Integer>>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int w = flights[i][2];
            adj.get(u).add(new Pair<>(v, w));
        }

        Queue<Pair<Integer,Pair<Integer,Integer>>> q = new LinkedList<>();

        q.add(new Pair<>(0, new Pair<>(src, 0))); //stops,src,distance
        List<Integer> distance = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));
        distance.set(src, 0);

        //dijkstra's
        while(!q.isEmpty())
        {
            Pair<Integer, Pair<Integer, Integer>> temp = q.poll();

            int stops = temp.first;
            int node = temp.second.first;
            int cost = temp.second.second;

            if(stops > k) continue;

            for(Pair<Integer, Integer> nbr : adj.get(node))
            {
                int adjNode = nbr.first;
                int weight = nbr.second;

                if(cost + weight < distance.get(adjNode) && stops <= k)
                {
                    distance.set(adjNode, cost + weight);
                    q.add(new Pair<>(stops+1, new Pair<>(adjNode,cost+weight)));
                }
            }
        }

        if(distance.get(dst)==Integer.MAX_VALUE) return -1;
        else return distance.get(dst);
    }
}