import java.util.Arrays;

class Solution
{
    public int[] deckRevealedIncreasing(int[] deck)
    {
        Arrays.sort(deck);
        int n = deck.length;

        int[] ans = new int[n];

        int idx = 0, i = 0;
        boolean skip = false;

        while(idx < n)
        {
            if(ans[i] == 0)
            {
                if(!skip)
                {
                    ans[i] = deck[idx];
                    idx++;
                }
                skip = !skip;
            }

            i = (i+1)%n;
        }
        return ans;

    }
}