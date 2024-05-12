import java.util.*;

class Solution
{
    private static class pair
    {
        double ratio;
        int idx;

        public pair(double ratio, int idx)
        {
            this.ratio = ratio;
            this.idx = idx;
        }
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int k)
    {
        List<pair> workers = new ArrayList<>();
        for(int i = 0; i < wage.length; i++) workers.add(new pair((double) wage[i]/quality[i], i));

        workers.sort(Comparator.comparingDouble(x->x.ratio));

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        int team = 0;

        for(int i = 0; i < k; i++)
        {
            int currWorkerQuality = quality[workers.get(i).idx];
            q.add(currWorkerQuality);
            team += currWorkerQuality;
        }

        double ans = team * workers.get(k-1).ratio;

        for(int lead = k; lead < wage.length; lead++)
        {
            double leadRatio = workers.get(lead).ratio;
            int currWorkerQuality = quality[workers.get(lead).idx];

            if(!q.isEmpty() && q.peek() > currWorkerQuality)
            {
                team = team - q.peek() + currWorkerQuality;
                q.remove();
                q.add(currWorkerQuality);
            }

            double captainTeamsRatio = leadRatio * team;
            ans = Math.min(ans, captainTeamsRatio);
        }

        return ans;
    }
}