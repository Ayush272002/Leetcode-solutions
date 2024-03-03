import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid)
    {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
        {
            return -1;
        }

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(0, 0));
        grid[0][0] = 1;

        while (!q.isEmpty())
        {
            Pair p = q.poll();

            int x = p.x;
            int y = p.y;
            int dist = grid[x][y];

            if(x == n-1 && y == n-1) return dist;

            for(int[] d : dir)
            {
                int newX = x + d[0];
                int newY = y + d[1];

                if(newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 0)
                {
                    q.add(new Pair(newX,newY));
                    grid[newX][newY] = dist +1;
                }
            }
        }

        return -1;
    }
}