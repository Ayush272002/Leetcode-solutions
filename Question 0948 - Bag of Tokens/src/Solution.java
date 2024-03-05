import java.util.Arrays;

class Solution
{
    public int bagOfTokensScore(int[] tokens, int power)
    {
        int start = 0, end = tokens.length-1;
        Arrays.sort(tokens);

        int maxScore = 0, currScore = 0;

        while(start <= end)
        {
            //playing face up
            if(power >= tokens[start])
            {
                power -= tokens[start];
                start++;
                currScore++;
            }
            else if(currScore >= 1) //face down
            {
                power += tokens[end];
                end--;
                currScore--;
            }
            else break; // If no token can be played, break the loop

            maxScore = Math.max(maxScore,currScore);
        }

        return maxScore;
    }
}