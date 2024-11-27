import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    private int bfs(int source, int target, List<List<Integer>> adjList, int n) {
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        q.add(source);
        dist[source] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int nbr : adjList.get(curr)) {
                if (dist[nbr] == -1) {
                    dist[nbr] = dist[curr] + 1;
                    if (nbr == target) {
                        return dist[target];
                    }

                    q.add(nbr);
                }
            }
        }

        return -1;

    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
            adjList.get(i).add(i + 1);
        }

        int[] ans = new int[queries.length];
        int idx = 0;

        for (int[] q : queries) {
            int u = q[0], v = q[1];
            adjList.get(u).add(v);

            ans[idx++] = bfs(0, n - 1, adjList, n);
        }

        return ans;
    }
}