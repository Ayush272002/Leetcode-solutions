import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution
{
    private void dfs1(int node, Map<Integer, List<Integer>> adj, int parent, int[] ans, int[] subtreeCount)
    {
        for(int nbr : adj.get(node))
        {
            if(nbr != parent)
            {
                dfs1(nbr, adj, node, ans, subtreeCount);
                ans[node] += ans[nbr] + subtreeCount[nbr];
                subtreeCount[node] += subtreeCount[nbr];
            }
        }

        subtreeCount[node]++;
    }

    private void dfs2(int node, Map<Integer, List<Integer>> adj, int parent, int[] ans, int[] subtreeCount, int n)
    {
        for(int nbr : adj.get(node))
        {
            if(nbr != parent)
            {
                ans[nbr] = (ans[node] - subtreeCount[nbr]) + (n - subtreeCount[nbr]);
                dfs2(nbr, adj, node, ans, subtreeCount, n);
            }
        }
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges)
    {
        Map<Integer, List<Integer>>  adj = new HashMap<>();
        for(int i = 0; i < n; i++) adj.put(i , new ArrayList<>());

        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] ans = new int[n];
        int[] subtreeCount = new int[n]; //subtreeCount[node]: the count of nodes in the subtree rooted at node

        dfs1(0, adj, -1, ans, subtreeCount); //after dfs1 , it will store correct ans of only the root node

        dfs2(0, adj, -1, ans, subtreeCount, n);

        return ans;
    }
}