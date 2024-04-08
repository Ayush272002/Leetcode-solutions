class Solution2
{
    public int countStudents(int[] students, int[] sandwiches)
    {
        int stud0 = 0, stud1 = 0;
        for(int n : students)
        {
            if(n == 0) stud0++;
            else stud1++;
        }

        for(int n : sandwiches)
        {
            if(n == 0 && stud0 > 0) stud0--;
            else if(n == 1 && stud1 > 0) stud1--;
            else return stud1+stud0;
        }

        return 0;
    }
}