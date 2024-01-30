import java.util.Stack;

class Solution {
    private boolean isNumeric(String str)
    {
        try
        {
            Double.parseDouble(str);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    private int calc(int num1 , int num2, String curr)
    {
        if(curr.equals("+")) return num1+num2;
        else if(curr.equals("-")) return num2-num1;
        else if(curr.equals("*")) return num1*num2;
        else if(curr.equals("/")) return num2/num1;
        else return -1;

    }
    public int evalRPN(String[] tokens)
    {
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < tokens.length; i++)
        {
            String curr = tokens[i];
            if(isNumeric(curr))
            {
                s.push(Integer.parseInt(curr));
            }
            else
            {
                int num1 = s.pop();
                int num2 = s.pop();

                int res = calc(num1, num2, curr);
                s.push(res);
            }
        }

        return s.peek();
    }
}