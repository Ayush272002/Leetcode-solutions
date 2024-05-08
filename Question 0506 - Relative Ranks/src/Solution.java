import java.util.Comparator;
import java.util.PriorityQueue;

class Solution
{
    private static class Pair
    {
        int first, second;

        public Pair(int first, int second)
        {
            this.first = first;
            this.second = second;
        }
    }
    public String[] findRelativeRanks(int[] score)
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt((Pair p)-> p.first).reversed());
        for(int i = 0; i < score.length; i++)
        {
            pq.add(new Pair(score[i], i));
        }

        String[] ans = new String[score.length];
        int i = 1;
        while(!pq.isEmpty())
        {
            Pair temp = pq.poll();

            if(i == 1) ans[temp.second] = "Gold Medal";
            else if(i == 2) ans[temp.second] = "Silver Medal";
            else if(i == 3) ans[temp.second] = "Bronze Medal";
            else ans[temp.second] = String.valueOf(i);

            i++;
        }

        return ans;
    }
}