import java.util.*;

class Solution
{
    private static class Node
    {
        int x, y, safety;

        public Node(int x, int y, int safety)
        {
            this.x = x;
            this.y = y;
            this.safety = safety;
        }
    }

    private int[][] generateGrid(List<List<Integer>> grid, int[][] dir)
    {
        int[][] ans = new int[grid.size()][grid.getFirst().size()];
        Arrays.stream(ans).forEach(r->Arrays.fill(r,-1));

        int n = grid.size(), m = grid.getFirst().size();
        Queue<Node> q = new LinkedList<>();
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                //Thief found
                if(grid.get(i).get(j) == 1)
                {
                    q.add(new Node(i, j, 0));
                    ans[i][j] = 0;
                }
            }
        }

        //bfs
        while (!q.isEmpty())
        {
            Node temp = q.poll();
            for(int[] d : dir)
            {
                int x = temp.x + d[0];
                int y = temp.y + d[1];

                if(x >= 0 && x < n && y >= 0 && y < m && ans[x][y] == -1)
                {
                    ans[x][y] = temp.safety + 1;
                    q.add(new Node(x, y, ans[x][y]));
                }
            }
        }

        return ans;
    }

    public int maximumSafenessFactor(List<List<Integer>> grid)
    {
        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int[][] mat = generateGrid(grid, dir);

        //max heap
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt((Node t) -> t.safety).reversed());
        q.add(new Node(0, 0, mat[0][0]));
        mat[0][0] = -1;

        //dijkstras
        while (!q.isEmpty())
        {
            Node temp = q.poll();
            if(temp.x == mat.length-1 && temp.y == mat[0].length-1) return temp.safety;

            for(int[] d : dir)
            {
                int x = temp.x + d[0];
                int y = temp.y + d[1];

                if(x >= 0 && x < mat.length && y >= 0 && y < mat[0].length && mat[x][y] != -1)
                {
                    q.add(new Node(x, y, Math.min(mat[x][y], temp.safety)));
                    mat[x][y] = -1;
                }
            }
        }

        return 0;
    }
}