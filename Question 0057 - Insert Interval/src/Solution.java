import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval)
    {
        List<List<Integer>> store = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++)
        {
            store.add(new ArrayList<>());
            for (int j = 0; j < 2; j++)
            {
                store.get(i).add(intervals[i][j]);
            }
        }

        store.add(new ArrayList<>());
        for (int i = 0; i < 2; i++) {
            store.getLast().add(newInterval[i]);
        }

        store.sort(Comparator.comparingInt(List::getFirst));

        List<List<Integer>> mergedIntervals = new ArrayList<>();
        for(List<Integer> interval : store)
        {
            if(mergedIntervals.isEmpty() || mergedIntervals.getLast().get(1) < interval.getFirst())
            {
                mergedIntervals.add(interval);
            }
            else
            {
                mergedIntervals.getLast().set(1,Math.max(mergedIntervals.getLast().get(1), interval.get(1)));
            }
        }

        int[][] result = new int[mergedIntervals.size()][2];
        for (int i = 0; i < mergedIntervals.size(); i++) {
            result[i][0] = mergedIntervals.get(i).get(0);
            result[i][1] = mergedIntervals.get(i).get(1);
        }

        return result;
    }
}