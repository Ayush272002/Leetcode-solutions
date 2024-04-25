import java.util.*;

class Solution
{
    public List<Integer> findMinHeightTrees(int n, int[][] edges)
    {
        List<Integer> ans = new ArrayList<>();

        if(n == 1)
        {
            ans.add(0);
            return ans;
        }

        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int i = 0; i < n; i++)
        {
            adj.put(i, new ArrayList<>());
        }

        List<Integer> inDeg = new ArrayList<>(Collections.nCopies(n,0));

        for(int[] edge : edges)
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);

            inDeg.set(edge[0], inDeg.get(edge[0]) + 1);
            inDeg.set(edge[1], inDeg.get(edge[1]) + 1);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++)
        {
            if(inDeg.get(i) == 1) q.add(i);
        }

        //remove nodes till we have 1 or 2, removing indeg = 1 cause they are leaf
        while(n > 2)
        {
            int size = q.size();
            n -= size;

            while(size > 0 && !q.isEmpty())
            {
                int node = q.poll();

                //reduce the indegree of its adj nodes
                for(int nbr : adj.get(node))
                {
                    inDeg.set(nbr, inDeg.get(nbr) - 1);

                    //if indeg becomes 1, again leaf
                    if(inDeg.get(nbr) == 1) q.add(nbr);
                }

                size--;
            }
        }

        //ans store
        while (!q.isEmpty()) ans.add(q.poll());

        return ans;
    }
}