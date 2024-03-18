import java.util.Arrays;
import java.util.Comparator;

class Solution
{
    public int findMinArrowShots(int[][] points)
    {
        Arrays.sort(points, Comparator.comparingInt(point -> point[0]));

        int arrows = 1;
        int prevEnd = points[0][1];

        for(int i = 1; i < points.length; i++)
        {
            int currStart = points[i][0];
            int currEnd = points[i][1];

            if(currStart > prevEnd)
            {
                arrows++;
                prevEnd = currEnd;
            }
            else prevEnd = Math.min(prevEnd,currEnd);
        }

        return arrows;
    }
}