class Solution
{
    public boolean checkValidString(String s)
    {
        int openMin = 0, openMax = 0;

        for(char ch : s.toCharArray())
        {
            if(ch == ')')
            {
                openMax--;
                openMin--;
            }
            else if(ch == '(')
            {
                openMin++;
                openMax++;
            }
            else //star 
            {
                openMin--;
                openMax++;
            }

            if(openMax < 0) return false;
            openMin = Math.max(0,openMin);
        }


        return openMin == 0;
    }
}