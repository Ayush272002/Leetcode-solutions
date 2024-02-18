import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] updateMatrix(int[][] mat)
    {
        Boolean[][] visited = new Boolean[mat.length][mat[0].length];
        int[][] ans = new int[mat.length][mat[0].length];

        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(mat[i][j] == 0)
                {
                    q.add(new Node(i,j,0));
                    visited[i][j] = true;
                }
                else visited[i][j] = false;
            }
        }

        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

        //do bfs
        while(!q.isEmpty())
        {
            Node temp = q.poll();
            int x = temp.x;
            int y = temp.y;
            int d = temp.distance;

            for(int[] dir : directions)
            {
                int nX = x+dir[0];
                int nY = y+dir[1];

                if (nX >= 0 && nX < mat.length && nY >= 0 && nY < mat[0].length && !visited[nX][nY])
                {
                    visited[nX][nY] = true;
                    ans[nX][nY] = mat[nX][nY] == 0 ? 0 : d+1;
                    q.add(new Node(nX,nY,ans[nX][nY]));
                }
            }

        }

        return ans;
    }
}