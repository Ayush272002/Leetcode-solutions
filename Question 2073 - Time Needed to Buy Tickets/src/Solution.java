class Solution
{
    public int timeRequiredToBuy(int[] tickets, int k)
    {
        int time = 0, n = tickets.length;
        while(tickets[k] != 0)
        {
            for(int i = 0; i < n; i++)
            {
                if(tickets[k] == 0) return time;
                if(tickets[i] == 0) continue;
                else
                {
                    time++;
                    tickets[i]--;
                }
            }
        }

        return time;
    }
}