import java.util.HashSet;
import java.util.Set;

class Solution
{

    public static class pair
    {
        private int x;
        private int y;

        public pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }

        @Override
        public boolean equals(Object obj)
        {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            pair other = (pair) obj;
            return x == other.x && y == other.y;
        }
    }

    public boolean isRectangleCover(int[][] rectangles)
    {
        int totalArea = 0;

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        Set<pair> points = new HashSet<>();

        for (int i=0; i<rectangles.length;i++)
        {
            totalArea += Math.abs((rectangles[i][2]-rectangles[i][0])*(rectangles[i][3]-rectangles[i][1]));

            minX = Math.min(minX, rectangles[i][0]);
            minY = Math.min(minY, rectangles[i][1]);

            maxX = Math.max(maxX, rectangles[i][2]);
            maxY = Math.max(maxY, rectangles[i][3]);

            pair p1 = new pair(rectangles[i][0], rectangles[i][1]);
            pair p2 = new pair(rectangles[i][2], rectangles[i][1]);
            pair p3 = new pair(rectangles[i][0], rectangles[i][3]);
            pair p4 = new pair(rectangles[i][2], rectangles[i][3]);

            pair[] pointsToRemove = {p1, p2, p3, p4};
            for (pair p : pointsToRemove)
            {
                if (points.contains(p)) points.remove(p);
                else points.add(p);
            }
        }
        int area = (maxX-minX)*(maxY-minY);
        if (totalArea != area || points.size() != 4) return false;

        pair p1 = new pair(minX, minY);
        pair p2 = new pair(minX, maxY);
        pair p3 = new pair(maxX, minY);
        pair p4 = new pair(maxX, maxY);

        return points.contains(p1) && points.contains(p2) && points.contains(p3) && points.contains(p4);
    }
}