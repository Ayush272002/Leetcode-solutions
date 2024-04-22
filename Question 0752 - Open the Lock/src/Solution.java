import java.util.*;

class Solution
{
    private class Pair
    {
        String num;
        int count;

        public Pair(String num, int count)
        {
            this.num = num;
            this.count = count;
        }
    }
    public int openLock(String[] deadends, String target)
    {
        Set<String> visited = new HashSet<>(List.of(deadends));
        if(visited.contains("0000")) return -1;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair("0000", 0));

        while(!q.isEmpty())
        {
            Pair temp = q.poll();

            String num = temp.num;
            int count = temp.count;

            if(Objects.equals(num, target)) return count;

            for (int i = 0; i < 4; i++)
            {
                int digit1 = (num.charAt(i) - '0' + 1 + 10)%10; // overflow handle
                int digit2 = (num.charAt(i) - '0' - 1 + 10)%10;

                String newNum1 = num.substring(0,i) + digit1 + num.substring(i+1);
                String newNum2 = num.substring(0,i) + digit2 + num.substring(i+1);

                if(!visited.contains(newNum1))
                {
                    visited.add(newNum1);
                    q.add(new Pair(newNum1, count+1));
                }

                if(!visited.contains(newNum2))
                {
                    visited.add(newNum2);
                    q.add(new Pair(newNum2, count+1));
                }
            }
        }

        return -1;
    }
}