import java.util.ArrayList;
import java.util.List;

class OptimisedSol
{
    public int[][] insert(int[][] intervals, int[] newInterval)
    {
        List<int[]> mergedInterval = new ArrayList<>();

        int nStart = newInterval[0], nEnd = newInterval[1];
        boolean add = false;

        for(int[] currInterval : intervals)
        {
            int currStart = currInterval[0], currEnd = currInterval[1];

            /* If the end of the current interval is before the start of the new interval,
             or if the new interval has been inserted already, add the current interval
             to the list of merged intervals
             */
            if(currEnd < nStart || add)
            {
                mergedInterval.add(new int[]{currStart, currEnd});
                continue;
            }

            // Update the start of the new interval to be the minimum of its current start
            // and the start of the current interval
            nStart = Math.min(nStart, currStart);

            // If the end of the new interval is before the start of the current interval,
            // add the new interval followed by the current interval to the list of merged intervals
            if(nEnd < currStart)
            {
                mergedInterval.add(new int[]{nStart,nEnd});
                mergedInterval.add(new int[]{currStart,currEnd});
                add = true;
                continue;
            }

            // If the end of the new interval is before or equal to the end of the current interval,
            // update the end of the new interval to be the end of the current interval
            if(nEnd <= currEnd)
            {
                mergedInterval.add(new int[]{nStart,currEnd});
                add = true;
            }
        }

        if(!add) mergedInterval.add(new int[]{nStart,nEnd});
        return mergedInterval.toArray(new int[mergedInterval.size()][]);
    }
}
