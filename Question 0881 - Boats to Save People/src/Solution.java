import java.util.Arrays;

class Solution
{
    public int numRescueBoats(int[] people, int limit)
    {
        Arrays.sort(people);

        int boat = 0;
        int i = 0, j = people.length -1;
        while(i <= j)
        {
            if(people[i] + people[j] <= limit) i++;
            j--;
            boat++;
        }

        return boat;
    }
}