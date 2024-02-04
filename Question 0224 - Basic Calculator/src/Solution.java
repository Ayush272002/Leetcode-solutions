import java.util.Stack;

class Solution {
    public int calculate(String s) {
        int sum = 0;
        int sign = 1; // 1 or -1

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(Character.isDigit(ch))
            {
                int num = 0;
                while(i<s.length() && Character.isDigit(s.charAt(i)))
                {
                    num = num*10 + (s.charAt(i)-'0');
                    i++;
                }
                i--;
                num *= sign;
                sign = 1;
                sum += num;
            }
            else if(ch == '(')
            {
                stack.push(sum);
                stack.push(sign);
                sum=0;
                sign= 1;
            }
            else if(ch == ')')
            {
                sum *= stack.pop();
                sum += stack.pop();
            }
            else if(ch=='-')
            {
                sign *= -1;
            }
        }
        return sum;
    }
}