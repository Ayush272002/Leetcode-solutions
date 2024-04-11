class Solution2
{
    public int timeRequiredToBuy(int[] tickets, int k)
    {
        int time = 0, n = tickets.length, val = tickets[k];

        for (int i = 0; i < n; i++)
        {
            if(tickets[i] >= val)
            {
                if(i <= k) time += val;
                else time += val-1;
            }
            else time += tickets[i];
        }

        return time;
    }
}