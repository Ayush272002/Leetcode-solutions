import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findLongestChain(int[][] pairs)
    {
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
        int count = 1;
        int ansEnd = pairs[0][1];

        for (int i = 0; i < pairs.length; i++) {
            if(pairs[i][0] > ansEnd)
            {
                count++;
                ansEnd = pairs[i][1];
            }
        }

        return count;
    }
}