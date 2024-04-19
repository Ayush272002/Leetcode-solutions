class Solution
{
    public static class UnionFind {

        private int[] parents;
        private int[] rank;
        private int connections;
        private int[] edges;

        public UnionFind(int n) {
            parents = new int[n];
            rank = new int[n];
            edges = new int[n];
            connections = n;

            for (int i = 0; i < n; i++) {
                parents[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int n1) {
            int res = n1;

            while (res != parents[res]) {
                parents[res] = parents[parents[res]];
                res = parents[res];
            }

            return res;
        }

        public boolean union(int n1, int n2) {
            int p1 = find(n1);
            int p2 = find(n2);

            if (p1 == p2) {
                edges[p1]++;
                return false;
            }

            if (rank[p2] > rank[p1]) {
                parents[p1] = p2;
                rank[p2] += rank[p1];
                edges[p2] += edges[p1] + 1;
            } else {
                parents[p2] = p1;
                rank[p1] += rank[p2];
                edges[p1] += edges[p2] + 1;
            }

            connections--;
            return true;
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        int ans = 0;

        for (int[] edge : edges)
            unionFind.union(edge[0], edge[1]);

        for (int i = 0; i < n; i++) {
            if (i == unionFind.find(i)) { // Use find method to get the parent
                int size = unionFind.rank[i]; // Use rank to get the size
                int nEdges = (size * (size - 1)) / 2;
                if (nEdges == unionFind.edges[i])
                    ans++;
            }
        }

        return ans;
    }
}