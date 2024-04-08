import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

class Solution
{
    public int countStudents(int[] students, int[] sandwiches)
    {
        Deque<Integer> stud = new ArrayDeque<>();
        Deque<Integer> sand = new ArrayDeque<>();

        for(int n : students)
        {
            stud.add(n);
        }

        for(int n : sandwiches)
        {
            sand.add(n);
        }

        boolean flag = true;
        while(flag && !stud.isEmpty())
        {
            flag = false;
            int n = stud.size();

            for(int i = 0; i < n; i++)
            {
                if(Objects.equals(stud.peek(), sand.peek()))
                {
                    stud.pollFirst();
                    sand.pollFirst();
                    flag = true;
                }
                else
                {
                    stud.addLast(stud.pollFirst());
                }
            }
        }

        return stud.size();
    }
}